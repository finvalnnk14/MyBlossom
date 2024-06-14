let menu = document.querySelector('#menu-bar');
let navbar = document.querySelector('.navbar');

menu.onclick = () => {
  menu.classList.toggle('fa-times');
  navbar.classList.toggle('active');
}

window.onscroll = () => {
  menu.classList.remove('fa-times');
  navbar.classList.remove('active');

  if (window.scrollY > 60) {
    document.querySelector('#scroll-top').classList.add('active');
  }
  else {
    document.querySelector('#scroll-top').classList.remove('active');
  }

}

document.getElementById('registerForm').addEventListener('submit', function (event) {
  event.preventDefault(); // Prevent default form submission

  const name = document.getElementById('name').value;
  const email = document.getElementById('userEmail').value;

  const userData = {
    username: name,
    email: email
  };

  axios.post('https://finavalentina.vercel.app/user/register', userData, {
    headers: {
      'Content-Type': 'application/json'
    }
  })
    .then(response => {
      // Handle successful response
      console.log(response.data);
      alert('Registration successful');
    })
    .catch(error => {
      // Handle error
      console.error('Error registering partner:', error);
      alert('Error registering partner');
    });
});