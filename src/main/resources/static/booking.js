function bookNow() {

    let booking = {
        customerName: document.getElementById("name").value,
        email: document.getElementById("email").value,
        persons: document.getElementById("persons").value,
        packageId: document.getElementById("packageId").value,
        status: "CONFIRMED"
    };

    fetch("http://localhost:8080/api/bookings", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(booking)
    })
    .then(res => res.json())
    .then(data => {
        document.getElementById("msg").innerHTML =
            "<h5 class='text-success'>🎉 Booking Successful!</h5>";
    })
    .catch(err => {
        document.getElementById("msg").innerHTML =
            "<h5 class='text-danger'>❌ Booking Failed</h5>";
    });
}