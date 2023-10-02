(function(){
    $("#tabclientes").on("click",".js-delete", function(){
        let botaoClicado = $(this);
        $("#btnsim")
            .attr("data-id", botaoClicado.attr("data-id"));
        $("#modalcliente").modal("show");
    });
})();
