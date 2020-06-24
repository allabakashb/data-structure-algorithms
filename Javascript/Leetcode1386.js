var maxNumberOfFamilies = function(n, reservedSeats) {
    
    let map = new Map();
    
    for (let i = 0; i < reservedSeats.length; i++) {
        
        let reserved;
        if (map.has(reservedSeats[i][0])) {
            
            reserved = map.get(reservedSeats[i][0]);
        } else {
            
            reserved = [];
            map.set(reservedSeats[i][0], reserved);
        }
        
        reserved[reservedSeats[i][1]] = true;
    }
    
    let seats = 0, groups = (n - map.size) * 2;
    
    map.forEach((reserved, key) => {
        
        let leftAisle1 = !reserved[2] && !reserved[3];
        let rightAisle1 = !reserved[4] && !reserved[5];
        let leftAisle2 = !reserved[6] && !reserved[7];
        let rightAisle2 = !reserved[8] && !reserved[9];
        
        if (leftAisle1 && rightAisle1) {
            
            ++groups;
            
            if (leftAisle2 && rightAisle2) {
                
                ++groups;
            }
        } else if ((rightAisle1 && leftAisle2) || (leftAisle2 && rightAisle2)) {
            
            ++groups;
        }
    });
    
    return groups;
};
