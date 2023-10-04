const draggable_list = document.getElementById('BidList');
const check = document.getElementById('check');
const askQueue = document.getElementById('AskList');

// Set up a timer to call fetchData every, for example, 5 seconds (5000 milliseconds)
// const interval = 10000; // 10 seconds
// setInterval(fetchData, interval);


const AAPLBid = [
  { price: 18.95, Qty : 50},
  { price: 19.00, Qty : 50},
  { price: 18.55, Qty : 40},
  { price: 18.85, Qty : 50},
  { price: 18.65, Qty : 10},
];

const AAPLAsk = [
  { price: 17.95, Qty : 100},
  { price: 16.55, Qty : 30},
  { price: 16.95, Qty : 20},
  { price: 20.95, Qty : 40},
  { price: 22.95, Qty : 60},
];


// Store listitems
const listItems = [];
// AAPLBid.sort((s1,s2)=>s1.price-s2.price);
// console.table(AAPLBid);

let dragStartIndex;

createList();
AskList();

// Insert list items into DOM
function createList() {
  // [...AAPLBid]
  //   .map(a => ({ value: a, sort: Math.random() }))
  //   .sort((a, b) => a.sort - b.sort)
  //   .map(a => a.value)
  //   .forEach((person, index) => {
     AAPLBid.sort((a, b) => b.price - a.price);

    AAPLBid.forEach((stock, index) => {
      const listItem = document.createElement('li');

      listItem.setAttribute('data-index', index);
        // <span class="number">${index + 5}</span>
      listItem.innerHTML = `
        <span class="number">${5 - index }</span>
        <div class="draggable" draggable="true">
        <p class="stock-name">Price: $${stock.price.toFixed(2)} | Qty: ${stock.Qty}</p> 
        <i class="fas fa-grip-lines"></i>
        </div>
      `;

      listItems.push(listItem);

      draggable_list.appendChild(listItem);
    });

  addEventListeners();
}

function AskList() {
  // [...AAPLBid]
  //   .map(a => ({ value: a, sort: Math.random() }))
  //   .sort((a, b) => a.sort - b.sort)
  //   .map(a => a.value)
  //   .forEach((person, index) => {
     AAPLAsk.sort((a, b) => a.price - b.price);

     AAPLAsk.forEach((stock, index) => {
      const listItem = document.createElement('li');

      listItem.setAttribute('data-index', index);
      listItem.innerHTML = `
        <span class="number">${index +1}</span>
        <div class="draggable" draggable="true">
        <p class="stock-name">Price: $${stock.price.toFixed(2)} | Qty: ${stock.Qty}</p> 
        <i class="fas fa-grip-lines"></i>
        </div>
      `;

      listItems.push(listItem);

      askQueue.appendChild(listItem);
    });
}


function dragStart() {
  // console.log('Event: ', 'dragstart');
  dragStartIndex = +this.closest('li').getAttribute('data-index');
}

function dragEnter() {
  // console.log('Event: ', 'dragenter');
  this.classList.add('over');
}

function dragLeave() {
  // console.log('Event: ', 'dragleave');
  this.classList.remove('over');
}

function dragOver(e) {
  // console.log('Event: ', 'dragover');
  e.preventDefault();
}

function dragDrop() {
  // console.log('Event: ', 'drop');
  const dragEndIndex = +this.getAttribute('data-index');
  swapItems(dragStartIndex, dragEndIndex);

  this.classList.remove('over');
}

// Swap list items that are drag and drop
// function swapItems(fromIndex, toIndex) {
//   const itemOne = listItems[fromIndex].querySelector('.draggable');
//   const itemTwo = listItems[toIndex].querySelector('.draggable');

//   listItems[fromIndex].appendChild(itemTwo);
//   listItems[toIndex].appendChild(itemOne);
// }
function swapItems(fromIndex, toIndex) {
  const itemOne = AAPLBid[fromIndex];
  AAPLBid[fromIndex] = AAPLBid[toIndex];
  AAPLBid[toIndex] = itemOne;
}

// Check the order of list items
// function checkOrder() {
//   listItems.forEach((listItem, index) => {
//     const personName = listItem.querySelector('.draggable').innerText.trim();

//     if (personName !== AAPLBid[index]) {
//       listItem.classList.add('wrong');
//     } else {
//       listItem.classList.remove('wrong');
//       listItem.classList.add('right');
//     }
//   });
// }
function checkOrder() {
  listItems.forEach((listItem, index) => {
    const item = AAPLBid[index];
    const priceElem = listItem.querySelector('.price');
    const qtyElem = listItem.querySelector('.qty');
    const price = parseFloat(priceElem.innerText.split(': ')[1]);
    const qty = parseInt(qtyElem.innerText.split(': ')[1]);

    if (item.price === price && item.Qty === qty) {
      listItem.classList.remove('wrong');
      listItem.classList.add('right');
    } else {
      listItem.classList.add('wrong');
      listItem.classList.remove('right');
    }
  });
}

function addEventListeners() {
  const draggables = document.querySelectorAll('.draggable');
  const dragListItems = document.querySelectorAll('.BidList li');

  draggables.forEach(draggable => {
    draggable.addEventListener('dragstart', dragStart);
  });

  dragListItems.forEach(item => {
    item.addEventListener('dragover', dragOver);
    item.addEventListener('drop', dragDrop);
    item.addEventListener('dragenter', dragEnter);
    item.addEventListener('dragleave', dragLeave);
  });
}

check.addEventListener('click', checkOrder);