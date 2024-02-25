Goal:
    My attempt follows the "optimal prefix code" as shown in the book on page 214.
    I aim to create an algorithm to encode ASCII characters into a binary sequence,
    where each binary sequence is not a prefix of any other sequence, so that the
    characters can be written without delimiting.

To Run:
    The computation is handled by the HuffmansAlgorithm class. Run the Main runnable class to use the program.
    First you should enter the amount of values, then the data should be input as [character,frequency] one line at a
    time. The output will print the characters and their encoded values to the console.

    i.e.

    Input number of values to encode:
    6

    --------------
    Enter: [letter,frequency]
    [a,12]
    --------------
    Enter: [letter,frequency]
    [b,42]
    --------------
    Enter: [letter,frequency]
    [c,123]
    --------------
    Enter: [letter,frequency]
    [d,54]
    --------------
    Enter: [letter,frequency]
    [e,32]
    --------------
    Enter: [letter,frequency]
    [f,45]

    Current values:
    [a,12]
    [b,42]
    [c,123]
    [d,54]
    [e,32]
    [f,45]

    --Encoding Dictionary--
    c -- 0
    b -- 100
    a -- 1010
    e -- 1011
    f -- 110
    d -- 111
