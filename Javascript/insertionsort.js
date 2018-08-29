exports.sort = function (numbers) {
    for (let i = 1; i < numbers.length; i++) {
        let num = numbers[i];
        /*let j = i - 1;
        while (j >= 0 && numbers[j] > num) {
            numbers[j + 1] = numbers[j];
            j--;
        }*/
        let j = i - 1;
        for (j = i - 1; j >= 0; j--) {
            if (numbers[j] > num) {
                numbers[j + 1] = numbers[j];
            } else {
                break;
            }
        }
        numbers[j + 1] = num;
    }
};

/*
* Time Complexity
*  O(n)
* */