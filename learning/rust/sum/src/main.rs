fn seqsum(seq: [u8; 6]) -> u8 {
    //Returns a u8 integer type.
    //u8: 8-bit unsigned integer type
    //The iter() method returns an iterator object of the collection
    //sum() method sums the elements of an iterator.
    //Takes each element, adds them together, and returns the result.
    seq.iter().sum()
}
fn main() {
    let seq = [5,6,1,8,3,7];
    println!("Sum: {}", seqsum(seq));
}
