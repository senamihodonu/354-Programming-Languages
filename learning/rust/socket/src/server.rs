use std::thread;
use std::net::{TcpListener, TcpStream, Shutdown};
use std::io::{Read, Write};
use std::env;
use std::ops::Mul;

/**
 * This server application will listen to incoming requests and send back all incoming data, 
 * thus acting as an "echo" server. The client application will send a small message and 
 * expect a reply with the same contents.
 */
fn handle_client(mut stream: TcpStream) {
    let mut data = [0 as u8; 50]; // using 50 byte buffer
    while match stream.read(&mut data) {
        Ok(size) => {
            let mut square = data * data;
            // echo everything!
            stream.write(&square[0..size]).unwrap();
            true
        },
        Err(_) => {
            println!("An error occurred, terminating connection with {}", stream.peer_addr().unwrap());
            stream.shutdown(Shutdown::Both).unwrap();
            false
        }
    } {}
}

fn main() {
    let args: Vec<String> = env::args().collect();
    let port_number = &args[1];

    let listener = TcpListener::bind("0.0.0.0:".to_owned()+port_number).unwrap();
    // accept connections and process them, spawning a new thread for each one
    println!("Server listening on port 1234");
    for stream in listener.incoming() {
        match stream {
            Ok(stream) => {
                println!("New connection: {}", stream.peer_addr().unwrap());
                thread::spawn(move|| {
                    // connection succeeded
                    handle_client(stream)
                });
            }
            Err(e) => {
                println!("Error: {}", e);
                /* connection failed */
            }
        }
    }
    // close the socket server
    drop(listener);
}
