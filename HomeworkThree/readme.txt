Goal:
    My attempt follows the "optimal prefix code" as shown in the book on page 214.
    I aim to create an algorithm to encode ASCII characters into a binary sequence,
    where each binary sequence is not a prefix of any other sequence, so that the
    characters can be written without delimiting.

To Run:
    The computation is handled by the HuffmansAlgorithm class. Run the Main runnable class to use the program.
    You should only have to input the filepath for the input values, and the filepath for the output values.

Input text file:
    The input text file should be formatted with the amount of terms first, then each term on its own line. The format
    for the terms should be [term,frequency]

    example:

        7
        [a,12]
        [b,34]
        [c,87]
        [q,456]
        [g,812]
        [p,43]
        [o,2]

    This file has 7 values, each of which is a tuple with a character and its frequency.
