let svcUtil = require('./svc');
let svc = new svcUtil();
let asc = svc.SORTING_TYPES.ASC;
let des = svc.SORTING_TYPES.DES;

exports.sort = function (numbers) {
    if(numbers.length < 2) {
        return numbers;
    }
    let length = numbers.length;
    let leftLastIndex = length/2;
    let rightStartIndex = length - leftLastIndex;
    let leftPart = numbers.slice(0, leftLastIndex);
    let rightPart = numbers.slice(rightStartIndex, length);
    leftPart = exports.sort(leftPart);
    rightPart = exports.sort(rightPart);
    numbers = merge(leftPart, rightPart, asc);
    return numbers;
};

function merge(leftPart, rightPart, type) {
    let newArray = [];
    let i = 0, j = 0, k =0;
    while(i < leftPart.length && j < rightPart.length) {
        if (svc.compare(type, leftPart[i], rightPart[j])) {
            newArray[k] = leftPart[i];
            i++;
        } else {
            newArray[k] = rightPart[j];
            j++;
        }
        k++;
    }
    
    let unmergedArray;
    if (i < leftPart.length) {
        unmergedArray = leftPart.splice(i, leftPart.length);
    }
    if (j < rightPart.length) {
        unmergedArray = rightPart.splice(j, rightPart.length);
    }
    for (i = 0; i < unmergedArray.length; i++) {
        newArray[k] = unmergedArray[i];
        k++;
    }
    return newArray;
}

/*
*
* Time Complexity
* O(nLogn)
*
*  ex: [ 3, 7, 9, 2, 4, 1]
*       [3, 7, 9] [2, 4, 1]
*       [3] [7,9] [2] [4,1]
*       [3] [7] [9] [2] [4] [1]
*       so on
*
*/