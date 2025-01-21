document.addEventListener('DOMContentLoaded', () => {
  console.log('ready')
  init()
});

function init() {
   onshowinfo();
}

function onshowinfo(){
    const modalinfo = document.getElementById('modalinfo')
    console.log('0')
    if (modalinfo) {
        modalinfo.addEventListener('show.bs.modal', (event) => {
            console.log('1')
            const button = event.relatedTarget
            const nombreplaya = button.getAttribute('data-bs-nombreplaya')
            const idplaya = button.getAttribute('data-bs-idplaya')

            modalinfo.querySelector('h4').textContent = nombreplaya

            // AJAX
            const xhr = new XMLHttpRequest();
            const url = "Controller?op=puntuacion&idplaya="+idplaya
            xhr.open("GET", url, true);
            xhr.onload = () => {
                console.log('2')
                  const modalbody = modalinfo.querySelector('.modal-body')
                  modalbody.innerHTML = xhr.responseText;
                
            };
            xhr.send();
        })
    }
}
