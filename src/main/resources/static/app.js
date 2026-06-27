document.addEventListener("DOMContentLoaded", loadPackages);

// Load all packages
function loadPackages() {
    fetch("http://localhost:8080/api/packages")
        .then(res => res.json())
        .then(data => renderCards(data));
}

// Render UI cards
function renderCards(data) {
    let container = document.getElementById("cards");
    container.innerHTML = "";

    data.forEach(pkg => {
        container.innerHTML += `
        <div class="col-md-4 mb-4">
            <div class="card shadow-lg">

                <img src="${pkg.imageUrl}" class="card-img-top" height="200">

                <div class="card-body">
                    <h5>${pkg.title}</h5>
                    <p>📍 ${pkg.location}</p>
                    <p>${pkg.description}</p>
                    <h6>💰 ₹${pkg.price}</h6>

                    <button class="btn btn-primary w-100"
                        onclick="window.location.href='booking.html'">
                        Book Now
                    </button>
                </div>
            </div>
        </div>`;
    });
}

// SEARCH FUNCTION
function searchPackages() {
    let location = document.getElementById("searchInput").value;

    if (location === "") {
        loadPackages();
        return;
    }

    fetch(`http://localhost:8080/api/packages/search?location=${location}`)
        .then(res => res.json())
        .then(data => renderCards(data));
}

// BOOKING FUNCTION (basic frontend)
function bookPackage(title) {
    let name = prompt("Enter your name:");
    let email = prompt("Enter your email:");

    if (!name || !email) {
        alert("Booking cancelled");
        return;
    }

    fetch("http://localhost:8080/api/bookings", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            customerName: name,
            email: email,
            packageId: 1,
            persons: 1,
            status: "CONFIRMED"
        })
    })
    .then(() => alert("🎉 Booking Successful!"));
}