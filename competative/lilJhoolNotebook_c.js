const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

let i = 0;
rl.on('line', (input) => {
    i++;
    perform(input, i);
});

function perform(input, line) {
    if (line === 1) {
        return;
    }
    input = Number(input);
    if (input % 2 !== 0) {
        console.log(-1);
    } else {
        let nt1 = 10;
        let nt2 = 12;
        
        let y = 0;
        let found = false;
        let total = 0;
        while(!found) {
            let r1 = (input - (12 * y))%10;
            let r2 = (input - (10 * y))%12;
            
            if (r1 === 0 || r2 === 0 ) {
                found = true;
                total = ((input - (12 * y))/10) + y;
            } else {
                if (r1 < 0 || r2 < 0) {
                    found = true;
                } else {
                    y++;
                }
            }
        }
        
        if (total > 0) {
            console.log(total);
        } else {
            console.log(-1);
        }
    }
}

/**
 *
 10x+12y = 32
 10x = 32 - 12y
 x = 32 - 12y / 10
 
 12y = 32 - 10x
 y = 32-10x/12
 *
 */

/*
Yes, you read it right - Little Jhool is back, but no, he's not over his break up, still. And he's sad, broken and depressed; thus, he decided to visit a psychologist. She tells him to think about his pleasant memories of childhood, and stay busy so as to not miss his ex-girlfriend.

She asks him about his favorite memories from childhood, and being the genius Mathematician Little Jhool is, he remembered that solving Mathematics problem given to him by his teacher was his favorite memory.

He had two types of notebooks, when he was a kid.

 problems could be solved in one page, in the first notebook.
 problems could be solved in one page, in the second notebook.
Little Jhool remembered how in order to maintain symmetry, if he was given with n problems in total to solve, he tore out pages from both notebooks, so no space was wasted. EVER!

But, now he's unable to solve his own problem because of his depression, and for the exercise of the week, he has to answer the queries asked by his psychologist.

Given n number of questions, print the minimum number of pages he needs to tear out from the combination of both the notebooks, so that no space is wasted.

Input Format:
The first line will contain t - number of test cases.

The second will contain an integer n - number of questions.

Output Format:
Corresponding to the input, print the minimum number of pages Little Jhool needs to tear out from the combination of both the notebooks. If it is NOT possible, print "1".

INPUT

2
23
32

OUTPUT
-1
3


INPUT2

3
12
10
44

INPUT3
2
444
342
 */