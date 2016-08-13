$(document).ready(function () {
    $('#tablaProf tbody').on('click', 'td', function () {
        var id = $(this).parent().find('td:eq(0)').html().trim();
        var id2 = $(this).parent().find('td:eq(1)').html().trim();
        $('#PROFESOR').val("" + id2);
        $('#profUSUARIO').val("" + id);
    });
    $('#tablaProfElim tbody').on('click', 'td', function () {
        var id = $(this).parent().find('td:eq(0)').html().trim();
        $('#nomProf').val("" + id);
    });
    $('#tablaAlum tbody').on('click', 'td', function () {
        var id = $(this).parent().find('td:eq(1)').html().trim();
        $('#nomAlum').val("" + id);
    });
    $('#tablaModif tbody').on('click', 'td', function () {
        var idModif = $(this).parent().find('td:eq(0)').html().trim();
        var idCurso = $(this).parent().find('td:eq(3)').html().trim();
        var idGrado = $(this).parent().find('td:eq(4)').html().trim();
        $('#CURSO').val("" + idCurso);
        $('#cursoCODIGO').val("" + idModif);
        $('#GRADO').val("" + idGrado);
    });
});