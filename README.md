# Leitner-system
Java implementation of foreign language lessons based on Leitner system.

# Method description
Leitner system is a method of efficient studying of foreign languages. This method makes student to repeat words which are difficult for him to remember more often than those he proved to remember correctly. For this purpose, buckets are used: all words are divided in some number of buckets (the less the index of bucket - the higher the chance of receiving a word from there). If student gives the correct translation, the word is moved to the next bucket (this way the chance of this word's appearance once again is decreasing), otherwise the word is moved to the first bucket with the highest chance of its appearance again.

