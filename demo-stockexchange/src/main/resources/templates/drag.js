document.addEventListener("DOMContentLoaded", function () {
  const bidQueue = document.getElementById('BidList');
  const check = document.getElementById('check');
  const askQueue = document.getElementById('AskList');

  let AAPLBid = [];
  let AAPLAsk = [];

  // Helper function to calculate volume from an array of orders
  function calculateVolume(orders) {
    return orders.reduce((totalVolume, order) => totalVolume + order.quantity, 0);
  }

  // Function to create list items and update chat content
  function updateChat(bidOrders, askOrders) {
    // Clear previous data
    bidQueue.innerHTML = "";
    askQueue.innerHTML = "";

    // Update AAPLBid and AAPLAsk with new data
    AAPLBid = bidOrders;
    AAPLAsk = askOrders;

    // Render the updated lists
    createList(bidQueue, AAPLBid);
    createList(askQueue, AAPLAsk);

    // Display data in the chat
    const chat = document.getElementById("chat");
    chat.innerHTML = `
      <p>Buyer Volume: ${calculateVolume(bidOrders)}</p>
      <p>Seller Volume: ${calculateVolume(askOrders)}</p>
    `;
  }

  // Function to create list items
  function createList(queue, orders) {
    orders.sort((a, b) => b.price - a.price);
    orders.forEach((stock, index) => {
      const listItem = document.createElement('li');
      
      listItem.innerHTML = `
        <span class="number">${5 - index}</span>
        <div class="draggable" draggable="true">
        <p class="stock-name">Price: $${stock.price.toFixed(2)} | Qty: ${stock.quantity}</p> 
        <i class="fas fa-grip-lines"></i>
        </div>
      `;

      queue.appendChild(listItem);
    });
  }

  // Fetch and display data when the page loads
  fetch("http://localhost:8081/transactions/atAuctionOrders?stockId=TSLA")
    .then(response => response.json())
    .then(data => {
      // Extract data from the JSON response
      const bidOrders = data.TSLA.bidOrders;
      const askOrders = data.TSLA.askOrders;

      // Update the chat with the extracted data
      updateChat(bidOrders, askOrders);
    })
    .catch(error => {
      console.error("Error fetching data:", error);
    });

  // Rest of your code...
  // ...

  // Add event listeners and other code as needed
});
