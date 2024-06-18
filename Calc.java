<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Basic Calculator</title>
  <link rel="stylesheet" href="styles.css">
</head>
<body>
  <div class="calculator">
    <div id="display" class="display">0</div>
    <div class="buttons">
      <button class="btn" data-action="clear">C</button>
      <button class="btn" data-action="delete">DEL</button>
      <button class="btn" data-action="operator">/</button>
      <button class="btn" data-action="operator">*</button>
      <button class="btn">7</button>
      <button class="btn">8</button>
      <button class="btn">9</button>
      <button class="btn" data-action="operator">-</button>
      <button class="btn">4</button>
      <button class="btn">5</button>
      <button class="btn">6</button>
      <button class="btn" data-action="operator">+</button>
      <button class="btn">1</button>
      <button class="btn">2</button>
      <button class="btn">3</button>
      <button class="btn" data-action="calculate">=</button>
      <button class="btn" id="zero">0</button>
      <button class="btn">.</button>
    </div>
  </div>
  <script src="script.js"></script>
</body>
</html>


#------------CSS code-----------

body {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  margin: 0;
  font-family: Arial, sans-serif;
  background-color: #f0f0f0;
}

.calculator {
  background-color: #fff;
  border-radius: 10px;
  box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
  padding: 20px;
}

.display {
  background-color: #222;
  color: #fff;
  font-size: 2em;
  text-align: right;
  padding: 10px;
  border-radius: 5px;
  margin-bottom: 20px;
}

.buttons {
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  gap: 10px;
}

.btn {
  background-color: #e0e0e0;
  border: none;
  border-radius: 5px;
  padding: 20px;
  font-size: 1.2em;
  cursor: pointer;
  transition: background-color 0.3s;
}

.btn:hover {
  background-color: #d0d0d0;
}

#zero {
  grid-column: span 2;
}

.btn[data-action="operator"] {
  background-color: #f9a825;
}

.btn[data-action="operator"]:hover {
  background-color: #f57c00;
}

.btn[data-action="calculate"] {
  background-color: #388e3c;
  color: #fff;
}

.btn[data-action="calculate"]:hover {
  background-color: #2e7d32;
}

.btn[data-action="clear"], .btn[data-action="delete"] {
  background-color: #d32f2f;
  color: #fff;
}

.btn[data-action="clear"]:hover, .btn[data-action="delete"]:hover {
  background-color: #c62828;
}




#---------------JS code--------------------------------

document.addEventListener('DOMContentLoaded', function () {
  const display = document.getElementById('display');
  const buttons = Array.from(document.getElementsByClassName('btn'));
  let displayValue = '0';

  buttons.forEach(button => {
    button.addEventListener('click', function () {
      const action = this.dataset.action;
      const buttonContent = this.textContent;
      const displayedNum = displayValue;
      
      if (!action) {
        // If the display is showing '0', replace it, otherwise append it
        displayValue = displayedNum === '0' ? buttonContent : displayedNum + buttonContent;
      } else if (action === 'clear') {
        displayValue = '0';
      } else if (action === 'delete') {
        displayValue = displayedNum.slice(0, -1) || '0';
      } else if (action === 'operator') {
        displayValue = displayedNum + ' ' + buttonContent + ' ';
      } else if (action === 'calculate') {
        displayValue = eval(displayedNum.replace(/x/g, '*')).toString();
      }

      display.textContent = displayValue;
    });
  });
});