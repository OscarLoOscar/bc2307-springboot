// /* 程式碼 */

// // Example data for testing
// var exampleData = [
//   {
//     time: "15:59:59",
//     volume: 100,
//     price: 188.75,
//     direction: "buy",
//   },
//   {
//     time: "15:59:59",
//     volume: 200,
//     price: 188.73,
//     direction: "sell",
//   },
//   {
//     time: "15:59:59",
//     volume: 300,
//     price: 188.76,
//     direction: "buy",
//   },
//   {
//     time: "15:59:59",
//     volume: 400,
//     price: 188.73,
//     direction: "sell",
//   },
//   {
//     time: "15:59:59",
//     volume: 500,
//     price: 188.76,
//     direction: "buy",
//   },
// ];

// // Initialize chart
// var ctx = document.getElementById("chart").getContext("2d");
// var chart = new Chart(ctx, {
//   type: "bar",
//   data: {
//     labels: [], // Empty initially
//     datasets: [
//       {
//         label: "成交量",
//         data: [], // Empty initially
//         backgroundColor: [],
//         borderColor: "black",
//         borderWidth: 1,
//       },
//       {
//         label: "成交價",
//         data: [], // Empty initially
//         backgroundColor: [],
//         borderColor: "black",
//         borderWidth: 1,
//       },
//     ],
//   },
//   options: {
//     responsive: true,
//     maintainAspectRatio: false,
//     scales: {
//       xAxes: [
//         {
//           type: "time",
//           time: {
//             unit: "minute",
//             displayFormats: {
//               minute: "HH:mm:ss",
//             },
//             tooltipFormat: "HH:mm:ss",
//           },
//         },
//       ],
//       yAxes: [
//         {
//           ticks: {
//             beginAtZero: true,
//             stepSize: 100,
//             callback: function (value) {
//               return "￥" + value;
//             },
//           },
//         },
//       ],
//     },
//   },
// });

// // Update data
// function updateData(data) {
//   // Clear all data points
//   chart.data.labels = [];
//   chart.data.datasets[0].data = [];
//   chart.data.datasets[1].data = [];
//   chart.data.datasets[0].backgroundColor = [];
//   chart.data.datasets[1].backgroundColor = [];

//   // Loop through trade data
//   for (var i = 0; i < data.length; i++) {
//     var volume = data[i].volume;
//     var price = data[i].price;
//     var direction = data[i].direction;

//     // Set color based on direction
//     var barColor = direction === "buy" ? "#00ff00" : direction === "sell" ? "#ff0000" : "#ccc";

//     chart.data.labels.push(data[i].time);
//     chart.data.datasets[0].data.push({
//       x: data[i].time,
//       y: volume,
//       backgroundColor: barColor,
//     });
//     chart.data.datasets[1].data.push({
//       x: data[i].time,
//       y: price,
//       backgroundColor: barColor,
//     });
//   }

//   chart.update();
// }

// // Fetch and update data every 1 second
// setInterval(function () {
//   // Use your existing code to fetch data and updateData function
//   // Replace the next two lines with your actual data retrieval logic
//   var data = getBars("bar", "buy", 188.75); // Fetch data
//   updateData(data); // Update chart with the fetched data
// }, 1000);


document.addEventListener("DOMContentLoaded", function () {
  const chat = document.getElementById("chat");
  const fetchButton = document.getElementById("fetch-button");

  fetchButton.addEventListener("click", function () {
      // Fetch data from the Spring Boot API endpoint
      fetch("localhost:8081/transactions/indicator")
          .then(response => response.json())
          .then(data => {
              // Display data in the chat
              chat.innerHTML = `
                  <p>Buyer Volume: ${data.buyerVolume}</p>
                  <p>Seller Volume: ${data.sellerVolume}</p>
              `;
          })
          .catch(error => {
              console.error("Error fetching data:", error);
          });
  });
});
