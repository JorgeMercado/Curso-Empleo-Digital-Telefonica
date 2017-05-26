        function handleClick(){
            elemento1 = document.getElementById('texto1');
            contenido1 = elemento1.innerHTML;
            alert(contenido1);
        }
        
        function handleClick2(){
            elemento2 = document.getElementById('texto2');
            texto_cambiado = "Este es el texto ya cambiado";
            elemento2.innerHTML = texto_cambiado;
        }

        function handleClick3(){
            elemento3 = document.getElementById('texto3');
            texto_ampliado = "Y esta es la frase para la ampliación del texto.";
            elemento3.innerHTML += texto_ampliado;
        }

        //lectura del elemento 1
        document.getElementById('enlace1').onclick = handleClick;
        //sustituir el elemento 2. El último paso está en la instrucción onclick
        document.getElementById('enlace2').onclick = handleClick2;
        //Ampliar el elemento 3. El último paso en la instrucción onclick
        document.getElementById('enlace3').onclick = handleClick3;