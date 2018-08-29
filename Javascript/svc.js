function SVC() {
    let SORTING_TYPES = {
        ASC: 'ASC',
        DES: 'DES'
    };
    function compare(type, value1, value2) {
        if(type === SORTING_TYPES.ASC) {
            return value1 < value2;
        } else {
            return value2 < value1;
        }
    }
    return {
        SORTING_TYPES: SORTING_TYPES,
        compare: compare
    }
}
module.exports = SVC;