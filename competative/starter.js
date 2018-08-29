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

}