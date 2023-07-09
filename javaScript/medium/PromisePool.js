var promisePool = async function(functions, n) {
    let init = false;
    let target = functions.length;

    let execute = function(resolve){
        if(!init){
            init = true;
            if(functions.length==0) resolve();
            for(let i=0;i<n;i++){
                let fn = functions.shift();
                if(fn) fn().then(() => {target--;execute(resolve)})
            }
        }
        else{
            let fn = functions.shift();
            if(fn) fn().then(() => {
                target--;
                execute(resolve)
            })
            else if(target==0){
                resolve();
            }
        }
    }

    return new Promise(async (resolve, reject) => {
        execute(resolve);
    })
};


