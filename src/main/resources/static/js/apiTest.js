// var username=document.getElementById('usernameR').value;
// var email=document.getElementById('emailR').value;
// var password=document.getElementById('passwordR').value;
//
// function korsat() {
//     // console.log(username);
//     // console.log(email);
//     // console.log(password);
//     console.log("password");
// }
function getname() {
    let anonim= "<a href='/login' class=\"col btn btn-success btn-lg m-4\">Kirish / Ro'yhatdan o'tish</a>";
    let user= "<a href='/logout' class=\"col btn btn-success btn-lg m-4\">Chiqish</a>";
    axios.get("/getusername").then(function (response) {
        // console.log(response.data);
        if (response.data==="anonymousUser"){
            document.getElementById("btns").innerHTML+=anonim;
        }
        else {
            document.getElementById("btns").innerHTML+=user;
        }
        document.getElementById("un").innerHTML=response.data;
    });
    getrole();
}

function getRatings() {
    let out=
        "<tr>" +
        "                    <th>O'rin</th>" +
        "                    <th>Username</th>" +
        "                    <th>Ochko</th>" +
        "</tr>";
    axios.get("/api/ratings").then(function (response) {
        if (response.status===200){

            let all=JSON.parse(JSON.stringify(response.data));
            // console.log(all);
            var i=1;
            all.forEach(function (one) {
                out+=
                    "<tr class='border col-8 text-center'>" +
                    "             <td>"+i+"</td>" +
                    "             <td>"+one.username+"</td>" +
                    "             <td>"+one.rating+"</td>" +
                    "</tr>";
                i++;
            });
            // console.log(out);
            document.getElementById("table").innerHTML+=out;

        }

    });

}

function getrole() {
    axios.get("/getrole").then(function (response) {
        // console.log(response);
        if(response.data==="USER"){
            document.getElementById("kabinet").href="/user";
            document.getElementById("kabinet").style.display="block";
        }
        else {
            if (response.data==="ADMIN"){
                document.getElementById("kabinet").href="/admin";
                document.getElementById("kabinet").style.display="block";
            }
        }

    });
}

function login() {
    // if ()


}