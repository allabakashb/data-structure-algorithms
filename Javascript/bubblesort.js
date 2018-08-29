exports.sort = function(numbers) {
    let length = numbers.length;
    let swapped = false;
    for (let i = 0; i < length; i++) {
        for (let j = 0; j < length - i; j++) {
            if (numbers[j] > numbers[j + 1]) {
                let temp = numbers[j];
                numbers[j] = numbers[j + 1];
                numbers[j + 1] = temp;
                swapped = true;
            }
        }
        if (!swapped) {
            break;
        }
    }
};

/*
* Time Complexity
*  O(n^2)
* */