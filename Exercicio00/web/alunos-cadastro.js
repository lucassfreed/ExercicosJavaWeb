function validarDados() {
    if ((!(validarNome())) || (!(validarNotas())) || (!(validarFrequencia()))) {
        event.preventDefault();
    }
}

function validarNome() {
    var nome = document.getElementById("campo-nome").value;
    var qntCaracteres = nome.length;
    apagarElementoSeExiste("span-campo-nome-menor-5");
    apagarElementoSeExiste("span-campo-nome-maior-100");
    if (qntCaracteres < 5) {
        gerarSpan(
                "span-campo-nome-menor-5",
                "Nome deve conter no mínimo 5 caracteres",
                "div-campo-nome"
                );
        adicionarClasse("campo-nome", "border-danger");
        apagarClasse("campo-nome", "border-success");
        return false;
    } else if (qntCaracteres > 100) {
        gerarSpan(
                "span-campo-nome-maior-100",
                "Nome deve conter no máximo 100 caracteres",
                "div-campo-nome"
                );
        adicionarClasse("campo-nome", "border-danger");
        apagarClasse("campo-nome", "border-success");
        return false;
    } else {
        adicionarClasse("campo-nome", "border-success");
        apagarClasse("campo-nome", "border-danger");
        return true;
    }
}

function validarNotas() {
    if (!validarNota1()) {
        return false
    } else if (!validarNota2()) {
        return false;
    } else if (!validarNota3()) {
        return false;
    } else {
        return true;
    }
}
function validarNota1() {
    var nota1 = document.getElementById("campo-nota1").value;
    apagarElementoSeExiste("span-campo-nota1-invalida");
    if (isNotaEntre0e10(nota1)) {
        gerarSpan(
                "span-campo-nota1-invalida",
                "A nota deve estar entre 0 e 10",
                "div-campo-nota1"
                );
        adicionarClasse("campo-nota1", "border-danger");
        apagarClasse("campo-nota1", "border-success");
        return false;
    } else if (isEmpty(nota1)) {
        return false;
    } else {
        adicionarClasse("campo-nota1", "border-success");
        apagarClasse("campo-nota1", "border-danger");
        return true;
    }
}

function validarNota2() {
    var nota2 = document.getElementById("campo-nota2").value;
    apagarElementoSeExiste("span-campo-nota2-invalida");
    if (isNotaEntre0e10(nota2)) {
        gerarSpan(
                "span-campo-nota2-invalida",
                "A nota deve estar entre 0 e 10",
                "div-campo-nota2"
                );
        adicionarClasse("campo-nota2", "border-danger");
        apagarClasse("campo-nota2", "border-success");
        return false;
    } else if (isEmpty(nota2)) {
        return false;
    } else {
        adicionarClasse("campo-nota2", "border-success");
        apagarClasse("campo-nota2", "border-danger");
        return true;
    }
}

function validarNota3() {
    var nota3 = document.getElementById("campo-nota3").value;
    apagarElementoSeExiste("span-campo-nota3-invalida");
    if (isNotaEntre0e10(nota3)) {
        gerarSpan(
                "span-campo-nota3-invalida",
                "A nota deve estar entre 0 e 10",
                "div-campo-nota3"
                );
        adicionarClasse("campo-nota3", "border-danger");
        apagarClasse("campo-nota3", "border-success");
        return false;
    } else if (isEmpty(nota3)) {
        return false;
    } else {
        adicionarClasse("campo-nota3", "border-success");
        apagarClasse("campo-nota3", "border-danger");
        return true;
    }
}

function validarFrequencia() {
    var frequencia = document.getElementById("campo-frequencia").value;
    apagarElementoSeExiste("span-campo-frequencia-invalida");
    if (!(isEmpty(frequencia))) {
        if (isFrequenciaEntre0e100(frequencia)) {
            gerarSpan(
                    "span-campo-frequencia-invalida",
                    "A frequência deve estar entre 0 e 100",
                    "div-campo-frequencia"
                    );
            adicionarClasse("campo-frequencia", "border-danger");
            apagarClasse("campo-frequencia", "border-success");
            return false;
        } else {
            adicionarClasse("campo-frequencia", "border-success");
            apagarClasse("campo-frequencia", "border-danger");
            return true;
        }
    }
}

function apagarClasse(id, classeCor) {
    document.getElementById(id).classList.remove(classeCor);
}

function adicionarClasse(id, classeCor) {
    document.getElementById(id).classList.add(classeCor);
}

function apagarElementoSeExiste(id) {
    if (document.contains(document.getElementById(id))) {
        document.getElementById(id).remove();
    }
}

function isNotaEntre0e10(nota) {
    if (nota < 0 || nota > 10)
        return true;
    return false;
}

function isFrequenciaEntre0e100(frequencia) {
    if (frequencia < 0 || frequencia > 100)
        return true;
    return false;
}

function gerarSpan(id, texto, idPai) {
    var span = document.createElement("span");
    span.id = id;
    span.textContent = texto;
    span.classList.add("text-danger");
    span.classList.add("font-weight-bold");
    document.getElementById(idPai).appendChild(span);
}

function isEmpty(obj) {
    for(var prop in obj) {
        if(obj.hasOwnProperty(prop))
            return false;
    }
    return true;
}


