use std::net::{TcpStream};
use std::io::{Read, Write};
use std::str::from_utf8;
use std::env;
use std::fmt::Display;

fn main() {
    let args: Vec<String> = env::args().collect();
    let port_number = &args[1];

    match TcpStream::connect("localhost:".to_owned()+port_number) {
        Ok(mut stream) => {
            println!("Successfully connected to server in port {}", port_number);

            let msg = b"Banana";

            stream.write(msg).unwrap();
            println!("Sent, awaiting reply...");

            let mut data = [0 as u8; 6]; // using 6 byte buffer
            match stream.read_exact(&mut data) {
                Ok(_) => {
                    if &data == msg {
                        println!("Reply is ok!");
                    } else {
                        let text = from_utf8(&data).unwrap();
                        println!("Unexpected reply: {}", text);
                    }
                },
                Err(e) => {
                    println!("Failed to receive data: {}", e);
                }
            }
        },
        Err(e) => {
            println!("Failed to connect: {}", e);
        }
    }
    println!("Terminated.");
}