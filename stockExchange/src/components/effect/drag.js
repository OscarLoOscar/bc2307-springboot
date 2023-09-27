// Create a file named "dragDirective.js" or any name you prefer.
import Vue from 'vue';

const dragDirective = {
  bind(el) {
    el.style.cursor = 'move';

    let startX, startY, initialX, initialY, isDragging = false;

    el.addEventListener('mousedown', (e) => {
      isDragging = true;
      startX = e.clientX - el.getBoundingClientRect().left;
      startY = e.clientY - el.getBoundingClientRect().top;
      initialX = el.style.left ? parseInt(el.style.left, 10) : 0;
      initialY = el.style.top ? parseInt(el.style.top, 10) : 0;

      document.onmousemove = (e) => {
        if (!isDragging) return;

        const newX = e.clientX - startX;
        const newY = e.clientY - startY;

        // Ensure the element stays within the viewport
        const maxX = window.innerWidth - el.offsetWidth;
        const maxY = window.innerHeight - el.offsetHeight;

        const left = Math.min(maxX, Math.max(0, newX + initialX));
        const top = Math.min(maxY, Math.max(0, newY + initialY));

        el.style.left = `${left}px`;
        el.style.top = `${top}px`;
      };

      document.onmouseup = () => {
        isDragging = false;
        document.onmousemove = null;
        document.onmouseup = null;
      };
    });
  },
};

Vue.directive('drag', dragDirective);
