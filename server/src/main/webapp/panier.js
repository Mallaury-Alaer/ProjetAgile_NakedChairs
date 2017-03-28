      affPanier();
      function affPanier(){
        document.getElementById("list-command").innerHTML="";
        document.getElementById("list-buy").innerHTML="";

        $.getJSON("/v1/panier", function(data) {

          var n="";
          var nPrix="";
          var s="";
          var sPrix="";
          var total=0;

          for(var i=0; i<data.length;i++){  
            if(data[i].utilisateur == "test" && data[i].valide == "Non"){
                 s+="<li class=\"list-group-item\"><input id=\"btnSuppr\" name=\""+data[i].id+"\" type=\"button\" value=\"Supprimer\" onclick=\"supprCommande(this.name)\">";
                 if(data[i].dossier=="oui"){
                  s+="Chaise ";

                  if(data[i].assise=="ronde"){
                    s+="ronde ";
                  }else{          
                    s+="rectangulaire ";
                  }

                  if(data[i].formeDossier=="ovale"){
                    s+="à dossier ovale ";
                  }else{          
                    s+="à dossier rectangulaire ";
                  }

                  if(data[i].accoudoir=="oui"){
                    s+="avec accoudoirs";
                  }else if(data[i].accoudoir=="non"){          
                    s+="sans accoudoirs";
                  }

                 }else if(data[i].dossier=="non"){
                  s+="Tabouret ";

                  if(data[i].assise=="ronde"){
                    s+="rond ";
                  }else{          
                    s+="rectangulaire ";
                  }

                 }
                 s+="</li>";
                 sPrix+="<li class=\"list-group-item\">"+data[i].prix+"€</li>";
                 total+=data[i].prix;
            }
          }
          s+="<li class=\"list-group-item\" style=\"background-color:#DCDCDC\">TOTAL</li>";
          sPrix+="<li class=\"list-group-item\" style=\"background-color:#DCDCDC\">"+total+"€</li>";
          n=$(s);
          n.appendTo("#list-command");
          nPrix=$(sPrix);
          nPrix.appendTo("#list-buy");

        });
      }

      function supprCommande(id){
         $.ajax({
                type : 'DELETE',
                contentType : 'application/json',
                url : "/v1/panier/"+id,
                dataType : "json",
                data : JSON.stringify({
                    "id" : id,
                })
            });


         affPanier();
      }

      function validerCommandes(){  
        document.getElementById("validation").innerHTML="";
        $.getJSON("/v1/panier", function(data) {
          var n="";
          var s="";
          var auMoinsUneCommande=false;
          for(var i=0; i<data.length;i++){  
            if(data[i].utilisateur == "test" && data[i].valide =="Non"){
              $.ajax({
                      type : 'PUT',
                      contentType : 'application/json',
                      url : "/v1/panier/"+data[i].id,
                      dataType : "json",
                      data : JSON.stringify({
                          "id" : data[i].id,
                      })
                  });
              auMoinsUneCommande=true;
            }
          }
            if(auMoinsUneCommande){
              s+="<p style=\"color:green\">Commande validée</p>";
              n=$(s);
              n.appendTo("#validation");
              affPanier();
            }
        });
      }