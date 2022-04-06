use std::fs::File; //file struct
use std::io::{prelude::*, BufReader}; //Helps with the read and write operations
use std::env;
extern crate regex;
use regex::Regex;

/**
 * Program exploring reading from/writing to a file and a little bit of regular 
 * expressions in Rust.
 */
fn main() {
    //Program takes in commandline arguments
    //read, write or regex
    let args: Vec<String> = env::args().collect();
    println!("{:?}", args);
    let command = &args[1];

    println!("{}  option selected", command);
    println!();

    if command.eq("read"){
        //read from a file
        let mut file = File::open("src/main.rs").expect("Can't open file!");
        let mut contents = String::new();
        file.read_to_string(&mut contents).expect("File not available");
        println!("File Contents:\n\n{}", contents);

        for cap in Regex::new(r"\d{1,4}").unwrap().find_iter(&contents) {
            println!("{:#?}", cap.as_str());
        }

    } else if command.eq("write") {
        //Writing to a file
        let mut file = File::create("output.txt").expect("Could not open file");
      
        let reader = BufReader::new(File::open("test.txt").expect("Cannot open file.txt"));

        for line in reader.lines() {
            for word in line.unwrap().split_whitespace() {
                println!("word '{}'", word);
                let mut owned: String = word.to_owned();
                owned.push_str(" "); //String concatnation 
                file.write_all(owned.as_bytes()).expect("Cannot write to file");
            }
        }

    } else if command.eq("regex"){
        //regular expression catching digits with max length of 4
        let mut file = File::open("src/main.rs").expect("Can't open file!");
        let mut contents = String::new();
        file.read_to_string(&mut contents).expect("File not available");
        println!("File Contents:\n\n{}", contents);

        for cap in Regex::new(r"\d{1,4}").unwrap().find_iter(&contents) {
            //The r in front of our regular expression makes it so that excape sequences are 
            //not needed!
            println!("{:#?}", cap.as_str());
        }   
    }
}