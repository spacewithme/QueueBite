async function login() {

    const email =
        document.getElementById("email").value;

    const password =
        document.getElementById("password").value;

    const response = await fetch(
        "http://localhost:8080/users/login",
        {
            method: "POST",

            headers: {
                "Content-Type": "application/json"
            },

            body: JSON.stringify({
                email,
                password
            })
        }
    );

    const data = await response.json();

    if (response.ok) {

        localStorage.setItem(
            "token",
            data.token
        );

        localStorage.setItem(
            "role",
            data.role
        );

        window.location.href = "menu.html";

    } else {

        document.getElementById("message")
            .innerText = data;
    }
}
async function loadMenu() {

    const token =
        localStorage.getItem("token");

    const response = await fetch(
        "http://localhost:8080/menu",
        {
            method: "GET",

            headers: {
                "Authorization":
                    "Bearer " + token
            }
        }
    );

    const data = await response.json();

    let output = "";

    data.forEach(item => {

        output += `
            <div>
                <h3>${item.itemName}</h3>
                <p>${item.description}</p>
                <p>&#8377; ${item.price}</p>
                <hr>
            </div>
        `;
    });

    document.getElementById("menuList")
        .innerHTML = output;
}