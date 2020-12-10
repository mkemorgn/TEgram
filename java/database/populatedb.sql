BEGIN TRANSACTION;

INSERT INTO public.users ( username, password_hash, role, activated, deleted) VALUES ( 'user1', '$2a$10$QBbJ5oIACbcA6w5qQ/iiouEphQGhGXUxtwvbwWn2072rb6iZAoNsG', 'ROLE_USER', true, false);
INSERT INTO public.users ( username, password_hash, role, activated, deleted) VALUES ( 'user2', '$2a$10$z.ZfdTwrjZkadjTKZIgD5OrM9ovN2QacC75UTX1E/vEttq8Qh9D.C', 'ROLE_USER', true, false);
INSERT INTO public.users ( username, password_hash, role, activated, deleted) VALUES ( 'user3', '$2a$10$EciTGklE6FirjBtwa9ApOONEbCemuS9GwaxgrvypP/RrGfcRto95W', 'ROLE_USER', true, false);


INSERT INTO public.pictures ( user_id, pic_url, pic_name, pic_server_name, description, private) VALUES ( 3, 'https://res.cloudinary.com/dr1xyxwvj/image/upload/v1607573500/3/yi2wwpz37sedzb8eujko.jpg', 'sheep.jpg', '3/yi2wwpz37sedzb8eujko', 'my sheeps', false);
INSERT INTO public.pictures ( user_id, pic_url, pic_name, pic_server_name, description, private) VALUES ( 3, 'https://res.cloudinary.com/dr1xyxwvj/image/upload/v1607573532/3/mwaa6n4pmzdpcyypeule.jpg', 'bike.jpg', '3/mwaa6n4pmzdpcyypeule', 'red bike', false);
INSERT INTO public.pictures ( user_id, pic_url, pic_name, pic_server_name, description, private) VALUES ( 3, 'https://res.cloudinary.com/dr1xyxwvj/image/upload/v1607574059/3/zgqnlklydhkrppoomy1y.jpg', 'bicycle.jpg', '3/zgqnlklydhkrppoomy1y', 'red bike', false);
INSERT INTO public.pictures ( user_id, pic_url, pic_name, pic_server_name, description, private) VALUES ( 3, 'https://res.cloudinary.com/dr1xyxwvj/image/upload/v1607574078/3/xqmz9fieg8d1conmztsk.jpg', 'boy-snow-hoodie.jpg', '3/xqmz9fieg8d1conmztsk', '', true);
INSERT INTO public.pictures ( user_id, pic_url, pic_name, pic_server_name, description, private) VALUES ( 3, 'https://res.cloudinary.com/dr1xyxwvj/image/upload/v1607574091/3/ngihonkghsvthrth2lll.jpg', 'jazz.jpg', '3/ngihonkghsvthrth2lll', '', true);
INSERT INTO public.pictures ( user_id, pic_url, pic_name, pic_server_name, description, private) VALUES ( 4, 'https://res.cloudinary.com/dr1xyxwvj/image/upload/v1607574173/4/waqhjmnhecqtuyomih9c.jpg', 'kitchen-bar.jpg', '4/waqhjmnhecqtuyomih9c', 'cook', false);
INSERT INTO public.pictures ( user_id, pic_url, pic_name, pic_server_name, description, private) VALUES ( 4, 'https://res.cloudinary.com/dr1xyxwvj/image/upload/v1607574191/4/nfpfdlpl2ybm8r6vzmdu.jpg', 'smiling-man.jpg', '4/nfpfdlpl2ybm8r6vzmdu', '', false);
INSERT INTO public.pictures ( user_id, pic_url, pic_name, pic_server_name, description, private) VALUES ( 4, 'https://res.cloudinary.com/dr1xyxwvj/image/upload/v1607574227/4/xz7fjwvhu2bojdtwyorx.jpg', 'nature-mountains.jpg', '4/xz7fjwvhu2bojdtwyorx', '', false);
INSERT INTO public.pictures ( user_id, pic_url, pic_name, pic_server_name, description, private) VALUES ( 4, 'https://res.cloudinary.com/dr1xyxwvj/image/upload/v1607574237/4/g1hcv2ltr2bc7tq38gbv.jpg', 'girl-urban-view.jpg', '4/g1hcv2ltr2bc7tq38gbv', '', false);
INSERT INTO public.pictures ( user_id, pic_url, pic_name, pic_server_name, description, private) VALUES ( 4, 'https://res.cloudinary.com/dr1xyxwvj/image/upload/v1607574282/4/bfu0tdnvlbvr9i42e4wo.jpg', 'architecture-signs.jpg', '4/bfu0tdnvlbvr9i42e4wo', '', true);
INSERT INTO public.pictures ( user_id, pic_url, pic_name, pic_server_name, description, private) VALUES ( 4, 'https://res.cloudinary.com/dr1xyxwvj/image/upload/v1607574357/4/zmmo04gwgvdheou28pkp.jpg', 'beach-boat.jpg', '4/zmmo04gwgvdheou28pkp', '', false);
INSERT INTO public.pictures ( user_id, pic_url, pic_name, pic_server_name, description, private) VALUES ( 5, 'https://res.cloudinary.com/dr1xyxwvj/image/upload/v1607574392/5/icv72lcynltpie0ahzwh.jpg', 'dessert.jpg', '5/icv72lcynltpie0ahzwh', '', false);
INSERT INTO public.pictures ( user_id, pic_url, pic_name, pic_server_name, description, private) VALUES ( 5, 'https://res.cloudinary.com/dr1xyxwvj/image/upload/v1607574424/5/rc5sotwydcrtea3ouhtw.jpg', 'fish-vegetables.jpg', '5/rc5sotwydcrtea3ouhtw', 'fish', false);
INSERT INTO public.pictures ( user_id, pic_url, pic_name, pic_server_name, description, private) VALUES ( 5, 'https://res.cloudinary.com/dr1xyxwvj/image/upload/v1607574451/5/fimjg7c4iedjfzkzzryg.jpg', 'pot-mussels.jpg', '5/fimjg7c4iedjfzkzzryg', 'love mussels', false);
INSERT INTO public.pictures ( user_id, pic_url, pic_name, pic_server_name, description, private) VALUES ( 5, 'https://res.cloudinary.com/dr1xyxwvj/image/upload/v1607574463/5/ev27myglfexomdwjp5pd.jpg', 'spices.jpg', '5/ev27myglfexomdwjp5pd', '', true);
INSERT INTO public.pictures ( user_id, pic_url, pic_name, pic_server_name, description, private) VALUES ( 1, 'https://res.cloudinary.com/dr1xyxwvj/image/upload/v1607574486/1/ebnrutmrrhaa8d7fpqyr.jpg', 'cat.jpg', '1/ebnrutmrrhaa8d7fpqyr', '', false);
INSERT INTO public.pictures ( user_id, pic_url, pic_name, pic_server_name, description, private) VALUES ( 1, 'https://res.cloudinary.com/dr1xyxwvj/image/upload/v1607574533/1/bdhrxjcitqrwojsvlzod.jpg', 'reindeer.jpg', '1/bdhrxjcitqrwojsvlzod', 'deer', false);
INSERT INTO public.pictures ( user_id, pic_url, pic_name, pic_server_name, description, private) VALUES ( 1, 'https://res.cloudinary.com/dr1xyxwvj/image/upload/v1607574554/1/tuarjpgb2e1bkqhzk1ho.jpg', 'three-dogs.jpg', '1/tuarjpgb2e1bkqhzk1ho', 'my dogs', true);

INSERT INTO public.favorites ( fav_name, user_id) VALUES ( 'my list', 3);

INSERT INTO public.favorite_picture (favorite_id, picture_id) VALUES (1, 1);
INSERT INTO public.favorite_picture (favorite_id, picture_id) VALUES (1, 2);
INSERT INTO public.favorite_picture (favorite_id, picture_id) VALUES (1, 3);
INSERT INTO public.favorite_picture (favorite_id, picture_id) VALUES (1, 4);

INSERT INTO public.ratings ( picture_id, user_id, rating) VALUES ( 1, 2, 5);
INSERT INTO public.ratings ( picture_id, user_id, rating) VALUES ( 2, 1, 4);
INSERT INTO public.ratings ( picture_id, user_id, rating) VALUES ( 3, 1, 5);
INSERT INTO public.ratings ( picture_id, user_id, rating) VALUES ( 3, 3, 5);
INSERT INTO public.ratings ( picture_id, user_id, rating) VALUES ( 3, 4, 5);
INSERT INTO public.ratings ( picture_id, user_id, rating) VALUES ( 3, 5, 4);
INSERT INTO public.ratings ( picture_id, user_id, rating) VALUES ( 4, 5, 4);
INSERT INTO public.ratings ( picture_id, user_id, rating) VALUES ( 6, 5, 4);
INSERT INTO public.ratings ( picture_id, user_id, rating) VALUES ( 6, 1, 4);
INSERT INTO public.ratings ( picture_id, user_id, rating) VALUES ( 6, 3, 4);
INSERT INTO public.ratings ( picture_id, user_id, rating) VALUES ( 7, 4, 5);
INSERT INTO public.ratings ( picture_id, user_id, rating) VALUES ( 7, 5, 5);
INSERT INTO public.ratings ( picture_id, user_id, rating) VALUES ( 7, 1, 5);

INSERT INTO public.likes ( picture_id, user_id) VALUES ( 1, 4);
INSERT INTO public.likes ( picture_id, user_id) VALUES ( 1, 5);
INSERT INTO public.likes ( picture_id, user_id) VALUES ( 1, 1);
INSERT INTO public.likes ( picture_id, user_id) VALUES ( 2, 1);
INSERT INTO public.likes ( picture_id, user_id) VALUES ( 2, 5);
INSERT INTO public.likes ( picture_id, user_id) VALUES ( 2, 4);
INSERT INTO public.likes ( picture_id, user_id) VALUES ( 2, 3);
INSERT INTO public.likes ( picture_id, user_id) VALUES ( 10, 3);
INSERT INTO public.likes ( picture_id, user_id) VALUES ( 10, 4);
INSERT INTO public.likes ( picture_id, user_id) VALUES ( 10, 5);
INSERT INTO public.likes ( picture_id, user_id) VALUES ( 10, 1);
INSERT INTO public.likes ( picture_id, user_id) VALUES ( 11, 1);
INSERT INTO public.likes ( picture_id, user_id) VALUES ( 11, 3);
INSERT INTO public.likes ( picture_id, user_id) VALUES ( 11, 4);
INSERT INTO public.likes ( picture_id, user_id) VALUES ( 11, 5);

INSERT INTO public.comments ( picture_id, user_id, comment) VALUES ( 7, 1, 'good picture');
INSERT INTO public.comments ( picture_id, user_id, comment) VALUES ( 7, 2, 'agreed good picture');
INSERT INTO public.comments ( picture_id, user_id, comment) VALUES ( 7, 3, 'avarage picture');
INSERT INTO public.comments ( picture_id, user_id, comment) VALUES ( 8, 3, 'avarage picture');
INSERT INTO public.comments ( picture_id, user_id, comment) VALUES ( 8, 4, 'abcd picture');

COMMIT TRANSACTION;
