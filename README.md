# Leitner-system
Java implementation of foreign language lessons based on Leitner system.

# Method description
Leitner system is a method of efficient studying of foreign languages. This method makes student to repeat words which are difficult for him to remember more often than those he proved to remember correctly. For this purpose, buckets are used: all words are divided in some number of buckets (the less the index of bucket - the higher the chance of receiving a word from there). If student gives the correct translation, the word is moved to the next bucket (this way the chance of this word's appearance once again is decreasing), otherwise the word is moved to the first bucket with the highest chance of its appearance again.

# InputScanner class
This input scanner is much more efficient than the standard one from Java. The usage of this scanner makes the process of input reading noticeably faster. This is achieved by using the fact that we need to only parse words from the provided input.

# Vocabulary
This class contains words and words combinations and their translations. This information is taken from the provided input via using InputScanner.

# Lesson
This class interacts with the user (student). Study() method begins the lesson based on leitner system. This class has its own vocabulary, which is created in the constructor with the provided input.

# General Rules
The whole project follows the rules of objective-oriented programming (each class implements only its functions and no more) and the rules of encapsulation. All possible errors and exceptions are handled in InputScanner and Vocabulary classes.
