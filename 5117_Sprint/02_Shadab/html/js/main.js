     var myWorker;
     function start() {
       console.log("WebWorker: Starting");
       myWorker = new Worker("./js/worker.js");
       myWorker.addEventListener("message", primeHandler, false);
       var maxNum = $('#upto').val();
       myWorker.postMessage({'cmd': 'start', 'upto': maxNum});
     }
     function stop() {
       if (myWorker) {
         var msg = "<br/>WebWorker: Terminating " + new Date();
         console.log(msg);
         $('#status').append(msg);
         myWorker.terminate();
         myWorker = null;
       }
     }
     function primeHandler(event) {
       console.log ('got e:'+event.data);
       if (is_numeric(event.data)) {
         $('#result').append(event.data);
       }
       else {
         // update our status div and remove the " so the text will be clear
         $('#status').append(JSON.stringify(event.data).replace(/"/g, "") );
       }
     }
     function is_numeric(input){
       return typeof(input)=='number';
     }