document.getElementById('loginForm').onsubmit = function(e) {
  const username = document.getElementById('username').value;
  const password = document.getElementById('password').value;

  if (username.trim() === '' || password.trim() === '') {
    e.preventDefault();
    const errorMessage = document.getElementById('errorMessage');
    errorMessage.style.display = 'block';
    errorMessage.textContent = 'Please fill in all fields';
  }
};
