const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

let i = 0;
let n = 0;
rl.on('line', (input) => {
    i++;
    perform(input, i);
});

function perform(input, line) {
    if (line === 1) {
        n = input;
        return;
    }
    
    let time = input.split(":");
    let hr = Number(time[0]);
    let mm = Number(time[1]);
    let ss = Number(time[2]);
    let found = false;
    let str = '';
    while(!found) {
        if (ss < 59) {
            ss++;
        } else {
            if (mm < 59) {
                mm++;
            } else {
                if(hr < 23) {
                    hr++;
                } else {
                    hr = 0;
                }
                mm = 0;
            }
            ss = 0;
        }
        if(check(hr, mm, ss)) {
            str = getStr(hr) + ':' + getStr(mm) + ':' + getStr(ss);
            found = true;
        }
    }
    console.log(str);
}

function check(hr, mm, ss) {
    hr = getArray(hr);
    mm = getArray(mm);
    ss = getArray(ss);
    return compare(hr, mm) && compare(hr, ss) && compare(mm, ss);
}

function getArray(int) {
    int = (int / 10) >= 1 ? int.toString() : ('0'+int);
    return int.split('');
}

function getStr(int) {
    return (int / 10) >= 1 ? int.toString() : ('0'+int);
}

function compare(array1 , array2) {
    for (let  i = 0; i < array1.length; i++) {
        for (let  j = 0; j < array2.length; j++) {
            if (array1[i] === array2[j]) {
                return false;
            }
        }
    }
    return array1[0] !== array1[1] && array2[0] !== array2[1];
}

/*
*
* Alice is a geeky girl. She has a lot of codes to execute but she always choose a lucky time to execute a code.

Time is shown in  hour format as hh:mm:ss
Time is said to be lucky if all the 6 characters (except ':') are different.
Given the time when she completed the code find a lucky time to execute it so that Alice need to wait as little as possible.

Input :

First line contains T, the number of test cases. Each of next T lines contains time when she completes a code (in format described above).

Output:

For each test case, output a single line containing lucky time (in format described above)

INPUT

3
00:00:00
12:59:59
23:59:59

OUTPUT
01:23:45
13:02:45
01:23:45


*/