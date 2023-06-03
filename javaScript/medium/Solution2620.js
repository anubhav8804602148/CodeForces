/**
 * @param {Function} fn
 */
function memoize(fn) {
    let results = {};
    return function(...args) {
        let inStr = isNaN(args[1])?args[0].toString():args[0]+"-"+args[1];
        if(!results[inStr]){
            results[inStr] = fn(...args);
        }
        return results[inStr];
    }
}
 
let callCount = 0;
const memoizedFn = memoize(function (a, b) {
 callCount += 1;
  return a + b;
})
memoizedFn(0,0) 
memoizedFn(0,0) 
console.log(callCount)
