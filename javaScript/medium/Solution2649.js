var inorderTraversal = function*(arr) {
    if(!arr) return;
    for(let el of arr){
        if(typeof el=='number') yield el;
        else yield* inorderTraversal(el);
    }
};