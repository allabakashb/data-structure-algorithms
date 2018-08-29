let data = require('../data/data.json')
let bubbleSort = require('./bubblesort');
let insertionSort = require('./insertionsort');
let mergeSort = require('./mergesort');

let startTime = 0;

function doSort() {
    //start(bubbleSort.sort, data, 'Bubble Sort');
    start(insertionSort.sort, data, 'Insertion Sort');
    start(mergeSort.sort, data, 'Merge Sort');
}

function start(sort, numbers, type) {
    startTime = getCurrentTime();
    sort(numbers);
    print(type);
}

function print(type) {
    /*let str = '';
    for (let i = 0; i < numbers.length; i++) {
        str += numbers[i] + ' ';
    }
    console.log(str);*/
    console.log(type + ' :: ' + (getCurrentTime() - startTime));
    startTime = 0;
}

function getCurrentTime() {
    return new Date().getTime()/1000;
}

function test() {
    let array = [];
    for (let i = 0; i < 10; i++) {
        array.push(Math.floor(Math.random(i) * 10000));
    }
    console.log(array.toString());
    //insertionSort.sort(array);
    array = mergeSort.sort(array);
    console.log(array.toString())
}

if (process.env.METHOD === 'test') {
    test();
} else {
    doSort();
}