const apiKey = 'AC5AdTVWRdwVyGK2hFkz7njf7HfRc7475FXnYehi';
const sol = 1000; // El número de sol que deseas consultar

// URL del API de la NASA
const apiUrl = 'js/data.json';

// Realizar una solicitud GET utilizando Fetch API
fetch(apiUrl)
  .then((response) => {
    if (!response.ok) {
      throw new Error('Error en la solicitud al API');
    }
    return response.json();
  })
  .then((data) => {
    console.log(data);
    printar(data)

  })
  .catch((error) => {
    console.error('Ocurrió un error:', error);
  });

function printar(data) {
  data.photos.forEach(obj => {
    let rover_photo = document.createElement("div");
    rover_photo.className = "rover_photo";
    let img = document.createElement("img");
    img.id = "img";
    let rover_details = document.createElement("div");
    rover_details.className = "rover_details";
    let id = document.createElement("div");
    id.className = "id";
    let sol = document.createElement("div");
    sol.className = "sol";
    let camera = document.createElement("div");
    camera.className = "camera";
    let date = document.createElement("div");
    date.className = "date";
    let rover = document.createElement("div");
    rover.className = "rover";
    let status = document.createElement("div");
    status.className = "status";

    let container = document.getElementById("container");
    container.appendChild(rover_photo);
    rover_photo.append(img,rover_details);

    rover_details.append(id,sol,camera,date,rover,status);

    img.src = obj.img_src;
    id.innerHTML= "ID: "+obj.id
    sol.innerHTML = "Sol: "+obj.sol;
    camera.innerHTML = "Camera: "+ obj.camera.full_name;
    date.innerHTML = "Earth Date: "+obj.earth_date;
    rover.innerHTML ="Rover: "+ obj.rover.name;
    status.innerHTML = "Status: "+obj.id;

  });
}