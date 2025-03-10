PGDMP     3    (    	            |           juego    10.1    13.3 )    ,           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            -           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            .           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            /           1262    40960    juego    DATABASE     P   CREATE DATABASE juego WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'C';
    DROP DATABASE juego;
                postgres    false                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
                postgres    false            0           0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                   postgres    false    3            �            1259    131072    avion    TABLE       CREATE TABLE public.avion (
    id integer NOT NULL,
    modelo character varying(25),
    peso double precision,
    depositototal double precision,
    combustibleactual double precision,
    salidasemergencia integer,
    chalecosdisp integer,
    asientos integer
);
    DROP TABLE public.avion;
       public            postgres    false    3            �            1259    131075    azafata    TABLE     [  CREATE TABLE public.azafata (
    idazafata integer NOT NULL,
    experienciaprevia boolean DEFAULT false,
    nombre character varying(25) NOT NULL,
    primerapellido character varying(25),
    telefono integer,
    correo character varying(50) NOT NULL,
    passwdcorreo character varying(100) NOT NULL,
    dniazafata character(9) NOT NULL
);
    DROP TABLE public.azafata;
       public            postgres    false    3            �            1259    131079    azafatavuelo    TABLE     c   CREATE TABLE public.azafatavuelo (
    idvuelo integer NOT NULL,
    idazafata integer NOT NULL
);
     DROP TABLE public.azafatavuelo;
       public            postgres    false    3            �            1259    131082    billete    TABLE     �   CREATE TABLE public.billete (
    idbillete integer NOT NULL,
    nasiento integer,
    dnipersona character varying(25),
    idvuelo integer
);
    DROP TABLE public.billete;
       public            postgres    false    3            �            1259    131085    persona    TABLE       CREATE TABLE public.persona (
    dni character(9) NOT NULL,
    nombre character varying(25) NOT NULL,
    primerapellido character varying(25),
    telefono integer,
    correo character varying(50) NOT NULL,
    passwdcorreo character varying(100) NOT NULL
);
    DROP TABLE public.persona;
       public            postgres    false    3            �            1259    131088    piloto    TABLE     �  CREATE TABLE public.piloto (
    idpiloto integer NOT NULL,
    nivelpiloto character(1),
    nombrepiloto character varying(25) NOT NULL,
    primerapellidopiloto character varying(25),
    telefonopiloto integer,
    correopiloto character varying(50) NOT NULL,
    passwdcorreopiloto character varying(100) NOT NULL,
    dnipiloto character(9) NOT NULL,
    CONSTRAINT piloto_nivelpiloto_check CHECK ((nivelpiloto = ANY (ARRAY['a'::bpchar, 'm'::bpchar, 'b'::bpchar])))
);
    DROP TABLE public.piloto;
       public            postgres    false    3            �            1259    131092    vuelo    TABLE     �   CREATE TABLE public.vuelo (
    idvuelo integer NOT NULL,
    origen character varying(25),
    destino character varying(25),
    km double precision,
    puertaembarque integer,
    idavion integer,
    idpiloto integer
);
    DROP TABLE public.vuelo;
       public            postgres    false    3            #          0    131072    avion 
   TABLE DATA           ~   COPY public.avion (id, modelo, peso, depositototal, combustibleactual, salidasemergencia, chalecosdisp, asientos) FROM stdin;
    public          postgres    false    196   �3       $          0    131075    azafata 
   TABLE DATA           �   COPY public.azafata (idazafata, experienciaprevia, nombre, primerapellido, telefono, correo, passwdcorreo, dniazafata) FROM stdin;
    public          postgres    false    197   4       %          0    131079    azafatavuelo 
   TABLE DATA           :   COPY public.azafatavuelo (idvuelo, idazafata) FROM stdin;
    public          postgres    false    198   e5       &          0    131082    billete 
   TABLE DATA           K   COPY public.billete (idbillete, nasiento, dnipersona, idvuelo) FROM stdin;
    public          postgres    false    199   �5       '          0    131085    persona 
   TABLE DATA           ^   COPY public.persona (dni, nombre, primerapellido, telefono, correo, passwdcorreo) FROM stdin;
    public          postgres    false    200   �5       (          0    131088    piloto 
   TABLE DATA           �   COPY public.piloto (idpiloto, nivelpiloto, nombrepiloto, primerapellidopiloto, telefonopiloto, correopiloto, passwdcorreopiloto, dnipiloto) FROM stdin;
    public          postgres    false    201   7       )          0    131092    vuelo 
   TABLE DATA           `   COPY public.vuelo (idvuelo, origen, destino, km, puertaembarque, idavion, idpiloto) FROM stdin;
    public          postgres    false    202   V8       �
           2606    131096    avion avion_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.avion
    ADD CONSTRAINT avion_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.avion DROP CONSTRAINT avion_pkey;
       public            postgres    false    196            �
           2606    131098    azafata azafata_correo_key 
   CONSTRAINT     W   ALTER TABLE ONLY public.azafata
    ADD CONSTRAINT azafata_correo_key UNIQUE (correo);
 D   ALTER TABLE ONLY public.azafata DROP CONSTRAINT azafata_correo_key;
       public            postgres    false    197            �
           2606    131100    azafata azafata_dniazafata_key 
   CONSTRAINT     _   ALTER TABLE ONLY public.azafata
    ADD CONSTRAINT azafata_dniazafata_key UNIQUE (dniazafata);
 H   ALTER TABLE ONLY public.azafata DROP CONSTRAINT azafata_dniazafata_key;
       public            postgres    false    197            �
           2606    131102     azafata azafata_passwdcorreo_key 
   CONSTRAINT     c   ALTER TABLE ONLY public.azafata
    ADD CONSTRAINT azafata_passwdcorreo_key UNIQUE (passwdcorreo);
 J   ALTER TABLE ONLY public.azafata DROP CONSTRAINT azafata_passwdcorreo_key;
       public            postgres    false    197            �
           2606    131104    azafata azafata_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.azafata
    ADD CONSTRAINT azafata_pkey PRIMARY KEY (idazafata);
 >   ALTER TABLE ONLY public.azafata DROP CONSTRAINT azafata_pkey;
       public            postgres    false    197            �
           2606    131106    azafatavuelo azafatavuelo_pkey 
   CONSTRAINT     l   ALTER TABLE ONLY public.azafatavuelo
    ADD CONSTRAINT azafatavuelo_pkey PRIMARY KEY (idvuelo, idazafata);
 H   ALTER TABLE ONLY public.azafatavuelo DROP CONSTRAINT azafatavuelo_pkey;
       public            postgres    false    198    198            �
           2606    131108    billete billete_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.billete
    ADD CONSTRAINT billete_pkey PRIMARY KEY (idbillete);
 >   ALTER TABLE ONLY public.billete DROP CONSTRAINT billete_pkey;
       public            postgres    false    199            �
           2606    131110    persona persona_correo_key 
   CONSTRAINT     W   ALTER TABLE ONLY public.persona
    ADD CONSTRAINT persona_correo_key UNIQUE (correo);
 D   ALTER TABLE ONLY public.persona DROP CONSTRAINT persona_correo_key;
       public            postgres    false    200            �
           2606    131112     persona persona_passwdcorreo_key 
   CONSTRAINT     c   ALTER TABLE ONLY public.persona
    ADD CONSTRAINT persona_passwdcorreo_key UNIQUE (passwdcorreo);
 J   ALTER TABLE ONLY public.persona DROP CONSTRAINT persona_passwdcorreo_key;
       public            postgres    false    200            �
           2606    131114    persona persona_pkey 
   CONSTRAINT     S   ALTER TABLE ONLY public.persona
    ADD CONSTRAINT persona_pkey PRIMARY KEY (dni);
 >   ALTER TABLE ONLY public.persona DROP CONSTRAINT persona_pkey;
       public            postgres    false    200            �
           2606    131116    piloto piloto_correopiloto_key 
   CONSTRAINT     a   ALTER TABLE ONLY public.piloto
    ADD CONSTRAINT piloto_correopiloto_key UNIQUE (correopiloto);
 H   ALTER TABLE ONLY public.piloto DROP CONSTRAINT piloto_correopiloto_key;
       public            postgres    false    201            �
           2606    131118    piloto piloto_dnipiloto_key 
   CONSTRAINT     [   ALTER TABLE ONLY public.piloto
    ADD CONSTRAINT piloto_dnipiloto_key UNIQUE (dnipiloto);
 E   ALTER TABLE ONLY public.piloto DROP CONSTRAINT piloto_dnipiloto_key;
       public            postgres    false    201            �
           2606    131120 $   piloto piloto_passwdcorreopiloto_key 
   CONSTRAINT     m   ALTER TABLE ONLY public.piloto
    ADD CONSTRAINT piloto_passwdcorreopiloto_key UNIQUE (passwdcorreopiloto);
 N   ALTER TABLE ONLY public.piloto DROP CONSTRAINT piloto_passwdcorreopiloto_key;
       public            postgres    false    201            �
           2606    131122    piloto piloto_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.piloto
    ADD CONSTRAINT piloto_pkey PRIMARY KEY (idpiloto);
 <   ALTER TABLE ONLY public.piloto DROP CONSTRAINT piloto_pkey;
       public            postgres    false    201            �
           2606    131124    vuelo vuelo_pkey 
   CONSTRAINT     S   ALTER TABLE ONLY public.vuelo
    ADD CONSTRAINT vuelo_pkey PRIMARY KEY (idvuelo);
 :   ALTER TABLE ONLY public.vuelo DROP CONSTRAINT vuelo_pkey;
       public            postgres    false    202            �
           2606    131125 (   azafatavuelo azafatavuelo_idazafata_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.azafatavuelo
    ADD CONSTRAINT azafatavuelo_idazafata_fkey FOREIGN KEY (idazafata) REFERENCES public.azafata(idazafata) ON UPDATE CASCADE ON DELETE CASCADE;
 R   ALTER TABLE ONLY public.azafatavuelo DROP CONSTRAINT azafatavuelo_idazafata_fkey;
       public          postgres    false    2703    197    198            �
           2606    131130 &   azafatavuelo azafatavuelo_idvuelo_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.azafatavuelo
    ADD CONSTRAINT azafatavuelo_idvuelo_fkey FOREIGN KEY (idvuelo) REFERENCES public.vuelo(idvuelo) ON UPDATE CASCADE ON DELETE CASCADE;
 P   ALTER TABLE ONLY public.azafatavuelo DROP CONSTRAINT azafatavuelo_idvuelo_fkey;
       public          postgres    false    202    198    2723            �
           2606    131135    billete billete_dnipersona_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.billete
    ADD CONSTRAINT billete_dnipersona_fkey FOREIGN KEY (dnipersona) REFERENCES public.persona(dni) ON UPDATE CASCADE ON DELETE RESTRICT;
 I   ALTER TABLE ONLY public.billete DROP CONSTRAINT billete_dnipersona_fkey;
       public          postgres    false    200    199    2713            �
           2606    131140    billete billete_idvuelo_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.billete
    ADD CONSTRAINT billete_idvuelo_fkey FOREIGN KEY (idvuelo) REFERENCES public.vuelo(idvuelo) ON UPDATE CASCADE ON DELETE RESTRICT;
 F   ALTER TABLE ONLY public.billete DROP CONSTRAINT billete_idvuelo_fkey;
       public          postgres    false    199    202    2723            �
           2606    131145    vuelo vuelo_idavion_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.vuelo
    ADD CONSTRAINT vuelo_idavion_fkey FOREIGN KEY (idavion) REFERENCES public.avion(id) ON UPDATE CASCADE ON DELETE RESTRICT;
 B   ALTER TABLE ONLY public.vuelo DROP CONSTRAINT vuelo_idavion_fkey;
       public          postgres    false    2695    196    202            �
           2606    131150    vuelo vuelo_idpiloto_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.vuelo
    ADD CONSTRAINT vuelo_idpiloto_fkey FOREIGN KEY (idpiloto) REFERENCES public.piloto(idpiloto) ON UPDATE CASCADE ON DELETE RESTRICT;
 C   ALTER TABLE ONLY public.vuelo DROP CONSTRAINT vuelo_idpiloto_fkey;
       public          postgres    false    2721    201    202            #   s   x�3�L�,J*-666�41400�425 S`Ҕ���$�eșX���PT���ȉ�ƀ�L�����s*8���Z ��`J��`���D�L8��;[ �#	�L@�@�=... �!      $   J  x�]�Kn\!EǼUdEQ�Y�De	�@Q��z����W�q&=�E���5�9�紷�q�>%F��U���[\�u��ۃ/ɨic�h�H����s�T%C�B��+��CK���UK+��%�*�s��^��빥����~$�RX�s��	3��z	l�]�2s�	:�M��&W���U�r-@&���f�~\�-���\�Zi�7�g��*�1�LG�^\�8�Jɐ���0�
v�d�y,I������a�R��V�������%>��rPM�_z��ǘ�Ӳ�2�A�y�Zz���ZGXo �{�ƹ��Q��QBY��W��Ǉm��6v��      %       x�3�4�2�4�2�4�2҆`l����� 4�x      &   <   x�%���0��^1H��Ih�?R��Y�k��k��$�	�34�Nʸ���=�t.Ixt
�      '   #  x�M�1N1E��aPǎ�A��hǑVf5��N�����峬���j����qM�q{R��A�a��G�w����L�6�:x���J�\�r�p�)T�{&��1�U:3��%��C��������+�ڝ��c�O��!G����{��Pj�u�v�޳粌Q��h�9��q�4�x��IU�R��[���1IX!��Vx�b}���H!D�<�R3�x�b%6 �o��rY5���"��d��6a�HCz�^m��*�U�	:�N	���k\�M�.-x{�۶��T��      (   2  x���1RC1Dk�Spƒ-Y�� �l�g2�0i8=�0)���j�o�����8�ٶ��3��'_�'�q���f��v:@^q9v��T�h]�*,"�ce�Q˪^P�׎�*I�iv���0?/�ᰳ���2*K���U�������0/�{�α����*KH�{��ȵ�fH��dy��RΙ�e�p �coGX}���"a��Ϲ��MMX�h������7��){$%�M�����6mI��`��5�.sn������1&�Ĥ\�չ�,%�����{x*��s�Ɂ������,�7x3�/      )     x�u��n�0���c*�<���QbUH.Ta��oR�;΢b����2L��)�m��l?�&�"��匣c�Y�{:����D��#O�x:$���=����,�M�=�{��-ײ\����DZ�R�=�/|�$urLat���cۿ��T�[.շ�o������T��3�j|��SzmɔG���B�<)��f�3���X���jZ��k'Z�n��(
�4�q����n�N�F�C
���t�j��I������aH��0��9X��     