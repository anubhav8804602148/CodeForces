var curry = function(fn) {
    let cargs = [];
    return function curried(...args) {
        cargs = cargs.concat(args);
        if(cargs.length>=fn.length) return fn(...cargs);
        return curried;
    };
};