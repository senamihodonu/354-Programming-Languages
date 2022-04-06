use std::net::{TcpStream};
use std::io::{Read, Write};
//use std::str::from_utf8;

fn main() {
    match TcpStream::connect("localhost:1234") {
        Ok(mut stream) => { //Ok(T) representing success and containing a value
            println!("Successfully connected to server in port 1234");

            let num = 2;

            //stream.write(msg);
            println!("Sent Hello, awaiting reply...");

            let mut data = [0 as u8; 6]; // using 6 byte buffer
            match stream.read_exact(&mut data) {
                Ok(_) => { //Ok(T) representing success and containing a value
                    println!(&data);

                },
                Err(e) => { //Err(E), representing error and containing an error value.
                    println!("Failed to receive data: {}", e);
                }
            }
        },
        Err(e) => { ////Err(E), representing error and containing an error value.
            println!("Failed to connect: {}", e);
        }
    }
    println!("Terminated.");
}