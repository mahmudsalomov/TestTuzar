let count = 0;
let testContent=document.getElementById("testContent");
let testTypes=
    "<a href='/test/test-process' class=\"btn btn-success col-2 text-center m-3 cat\">\n" +
    "            Savollar to'foni\n" +
    "        </a>\n" +
    "        <a class=\"btn btn-success col-2 text-center m-3 cat\">\n" +
    "            So'zlar ma'nosi\n" +
    "        </a>\n" +
    "        <a class=\"btn btn-success col-2 text-center m-3 cat\">\n" +
    "            Bexato yoz\n" +
    "        </a>\n" +
    "        <a class=\"btn btn-success col-2 text-center m-3 cat\">\n" +
    "            So'z tuz\n" +
    "        </a>\n" +
    "        <a class=\"btn btn-success col-2 text-center m-3 cat\">\n" +
    "            Antonim vs Sinonim\n" +
    "        </a>\n" +
    "        <a class=\"btn btn-success col-2 text-center m-3 cat\">\n" +
    "            Bu ne ibora bo'ldi\n" +
    "        </a>\n" +
    "        <a class=\"btn btn-success col-2 text-center m-3 cat\">\n" +
    "            Yana nimadir\n" +
    "        </a>\n" +
    "        <a class=\"btn btn-success col-2 text-center m-3 cat\">\n" +
    "            Yana nimadir\n" +
    "        </a>\n" +
    "        <a class=\"btn btn-success col-2 text-center m-3 cat\">\n" +
    "            Yana nimadir\n" +
    "        </a>";

function single(){
    testContent.innerHTML=testTypes;
}

function check(choice,id) {
    // console.log("Javob = "+choice);

    axios.post("/test/api/check", null, {params: {choice:choice, id:id} })
        .then(function (response) {
            if (response.status===200){
                // console.log(response.data);
                if (response.data===true){
                    // setInterval(updateTimer,1000);
                    boshlash();
                    count++;
                }
                else {
                    clearInterval(intervalID);
                    document.getElementById("tasdiq").style.display="none";
                    document.getElementById("alert").style.display="block";
                    document.getElementById("result").innerHTML="Umumiy natijangiz: "+count;
                    console.log(count);
                    // cancel();
                }
            }
            else cancel();

        })
}

function boshlash() {
    const btn = document.querySelector('#btn');
    const id = document.getElementById('id').value;
    const rbs = document.querySelectorAll('input[name="choice"]');
    for (const rb of rbs) {
        if (rb.checked) {
            rb.checked=false;
            // alert(rb.value);
            break;
        }
    }
    axios.get("/test/api/test")
        .then(function (response) {
            if (response.status===200){
                // console.log(response);
                const data=JSON.parse(JSON.stringify(response.data));
                console.log(data);
                document.getElementById("test").style.display="block";
                document.getElementById("btns").style.display="none";
                document.getElementById("question").innerHTML=data.question;
                document.getElementById("0").innerHTML=data.variants[0];
                document.getElementById("1").innerHTML=data.variants[1];
                document.getElementById("2").innerHTML=data.variants[2];
                document.getElementById("3").innerHTML=data.variants[3];
                document.getElementById("a").value=data.variants[0];
                document.getElementById("b").value=data.variants[1];
                document.getElementById("c").value=data.variants[2];
                document.getElementById("d").value=data.variants[3];
                document.getElementById("id").value=data.id;
                time=0;
                clearInterval(intervalID);
                addTime(data.time);


            }
        });
}

// let startMinutes=0;
let time=0;
let intervalID=null;
const timer=document.getElementById("timer");
function addTime(amountTime){
    // startMinutes=amountTime;
    intervalID=setInterval(updateTimer,1000);
    time=amountTime;
}
function updateTimer() {

    const minutes=Math.floor(time/60);
    let seconds=time%60;
    if (minutes<10){
        if (seconds<10){
            timer.innerHTML="0"+minutes+":0"+seconds;
        }
        else {
            timer.innerHTML="0"+minutes+":"+seconds;
        }
    }
    else {
        if (seconds<10){
            timer.innerHTML=""+minutes+":0"+seconds;
        }
        else {
            timer.innerHTML=""+minutes+":"+seconds;
        }
    }
    if (minutes===0&&seconds===0){
        clearInterval(intervalID);
        tasdiq();
    }
    if (seconds<10){
        timer.style.color="red";
    }
    else {
        timer.style.color="black";
    }

    if (time!==0){
        time--;
    }


}


function tasdiq() {
    const btn = document.querySelector('#btn');
    const id = document.getElementById('id').value;
    const rbs = document.querySelectorAll('input[name="choice"]');
        let selectedValue;
        let k=0;
        for (const rb of rbs) {
            if (rb.checked) {
                selectedValue = rb.value;
                check(selectedValue,id);
                // alert(rb.value);
                break;
            }
            k++;
        }
        if (k===4){
            check("",id);
        }
        // alert(selectedValue);
}



function cancel() {
    window.location="/";
}