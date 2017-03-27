var renderer, scene, camera, dossierRect, dossierOval, assiseRect, assiseOvale, accoud1, accoud2, accoud11, accoud22, pied1, pied2, pied3, pied4, skybox;


function init(tissu,dossier,formeD,accoudoir,assise){
  renderer = new THREE.WebGLRenderer();
  renderer.setSize( window.innerWidth/2, window.innerHeight/2);
  document.getElementById('webGLVisu').appendChild(renderer.domElement);
  scene = new THREE.Scene();
  camera = new THREE.PerspectiveCamera(10, window.innerWidth / window.innerHeight, 1, 10000 );
  camera.position.set(0, 0.5, 50);
  scene.add(camera);

/*Skybox*/
  var geometry = new THREE.BoxGeometry(20, 20, 1);//Type d'objet
  var texture = new THREE.TextureLoader().load( 'ressources/images-chaises/mur.png' );//Texture
  var material = new THREE.MeshPhongMaterial( { map: texture } );//Application de la texture
   skybox = new THREE.Mesh(geometry, material);//Création de l'objet
  scene.add(skybox);//Ajout de l'objet à la scène

  /*cubes*/
  if(assise=="rectangulaire"){
    geometry = new THREE.BoxGeometry(2, 0.4, 2);//Type d'objet
    texture = new THREE.TextureLoader().load( tissu );//Texture
    material = new THREE.MeshPhongMaterial( { map: texture});//Application de la texture
    assiseRect = new THREE.Mesh( geometry, material );
    assiseRect.position.set(0,0.5,10);
    scene.add( assiseRect );
    assiseRect.rotation.y = 1;
  }else if(assise=="ronde"){
    geometry = new THREE.CylinderGeometry( 1.4, 1.4, 0.4, 15 );
    texture = new THREE.TextureLoader().load( tissu );//Texture
    material = new THREE.MeshPhongMaterial( { map: texture});//Application de la texture
    assiseOvale = new THREE.Mesh( geometry, material );
    assiseOvale.position.set(0,0.5,10);
    scene.add( assiseOvale );
    assiseOvale.rotation.y = 1;
  }

  if(dossier=="oui"){
    if(formeD=="rectangulaire"){
      geometry = new THREE.BoxGeometry(0.3, 2.4, 2);//Type d'objet
      texture = new THREE.TextureLoader().load( tissu );//Texture
      material = new THREE.MeshPhongMaterial( { map: texture});//Application de la texture
      dossierRect = new THREE.Mesh( geometry, material );
      dossierRect.position.set(0.57,1.6,6);
      scene.add( dossierRect );
      dossierRect.rotation.y = 1;
    }else if(formeD=="ovale"){
      geometry = new THREE.CylinderGeometry( 1.4, 1.4, 0.4, 15 );
      texture = new THREE.TextureLoader().load( tissu );//Texture
      material = new THREE.MeshPhongMaterial( { map: texture});//Application de la texture
      dossierOval = new THREE.Mesh( geometry, material );
      dossierOval.position.set(0.6,1.7,6);
      scene.add( dossierOval );
      dossierOval.rotation.z = 0.7; 
      dossierOval.rotation.x = 1.5;         
    }

    if(accoudoir=="oui"){
        geometry = new THREE.BoxGeometry(2, 0.2, 0.2);//Type d'objet
        texture = new THREE.TextureLoader().load( 'ressources/images-chaises/bois.png' );//Texture
        material = new THREE.MeshPhongMaterial( { map: texture});//Application de la texture
        accoud1 = new THREE.Mesh( geometry, material );
        accoud1.position.set(0.82,1.2,8);
        scene.add( accoud1 );
        accoud1.rotation.y = 1;

        geometry = new THREE.BoxGeometry(2, 0.2, 0.2);//Type d'objet
        texture = new THREE.TextureLoader().load( 'ressources/images-chaises/bois.png' );//Texture
        material = new THREE.MeshPhongMaterial( { map: texture});//Application de la texture
        accoud2 = new THREE.Mesh( geometry, material );
        accoud2.position.set(-0.85,1.22,6);
        scene.add( accoud2 );
        accoud2.rotation.y = 1;


        geometry = new THREE.BoxGeometry(0.2, 0.6, 0.2);//Type d'objet
        texture = new THREE.TextureLoader().load( 'ressources/images-chaises/bois.png' );//Texture
        material = new THREE.MeshPhongMaterial( { map: texture});//Application de la texture
        accoud11 = new THREE.Mesh( geometry, material );
        accoud11.position.set(-1.25,0.95,10);
        scene.add( accoud11 );
        accoud11.rotation.y = 1;

        geometry = new THREE.BoxGeometry(0.2, 0.6, 0.2);//Type d'objet
        texture = new THREE.TextureLoader().load( 'ressources/images-chaises/bois.png' );//Texture
        material = new THREE.MeshPhongMaterial( { map: texture});//Application de la texture
        accoud22 = new THREE.Mesh( geometry, material );
        accoud22.position.set(0.22,0.95,11);
        scene.add( accoud22 );
        accoud22.rotation.y = 1;
    }
  }


  geometry = new THREE.BoxGeometry(0.2, 1.8, 0.2);//Type d'objet
  texture = new THREE.TextureLoader().load( 'ressources/images-chaises/bois.png' );//Texture
  material = new THREE.MeshPhongMaterial( { map: texture});//Application de la texture
  pied1 = new THREE.Mesh( geometry, material );
  pied1.position.set(-1.25,-0.5,10);
  scene.add( pied1 );
  pied1.rotation.y = 1;

  geometry = new THREE.BoxGeometry(0.2, 1.8, 0.2);//Type d'objet
  texture = new THREE.TextureLoader().load( 'ressources/images-chaises/bois.png' );//Texture
  material = new THREE.MeshPhongMaterial( { map: texture});//Application de la texture
  pied2 = new THREE.Mesh( geometry, material );
  pied2.position.set(1.3,-0.5,8);
  scene.add( pied2 );
  pied2.rotation.y = 1;

  geometry = new THREE.BoxGeometry(0.2, 1.8, 0.2);//Type d'objet
  texture = new THREE.TextureLoader().load( 'ressources/images-chaises/bois.png' );//Texture
  material = new THREE.MeshPhongMaterial( { map: texture});//Application de la texture
  pied3 = new THREE.Mesh( geometry, material );
  pied3.position.set(0.2,-0.5,11);
  scene.add( pied3 );
  pied3.rotation.y = 1;

  geometry = new THREE.BoxGeometry(0.2, 1.8, 0.2);//Type d'objet
  texture = new THREE.TextureLoader().load( 'ressources/images-chaises/bois.png' );//Texture
  material = new THREE.MeshPhongMaterial( { map: texture});//Application de la texture
  pied4 = new THREE.Mesh( geometry, material );
  pied4.position.set(-0.22,-0.53,6);
  scene.add( pied4 );
  pied4.rotation.y = 1;


  /*lumiere*/
  var lumiere = new THREE.DirectionalLight( 0xffffff, 1.2 );
  lumiere.position.set( 0, -300, 400 );
  scene.add( lumiere );


  animate();
}

function animate(){
  requestAnimationFrame( animate );
  renderer.render( scene, camera );
}