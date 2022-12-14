PGDMP                          z            Bank    14.3    14.3                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    16523    Bank    DATABASE     c   CREATE DATABASE "Bank" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Russian_Russia.1251';
    DROP DATABASE "Bank";
                postgres    false            ?            1259    16531    Card    TABLE     a  CREATE TABLE public."Card" (
    id bigint NOT NULL,
    "mainBalance" double precision NOT NULL,
    "mainCurrency" character(3) NOT NULL,
    activity boolean NOT NULL,
    cvc smallint NOT NULL,
    "paymentSystem" character varying(10) NOT NULL,
    "dateOfCreation" date NOT NULL,
    "dateOfEnd" date NOT NULL,
    "idOfClient" bigint NOT NULL
);
    DROP TABLE public."Card";
       public         heap    postgres    false            ?            1259    16530    Card_id_seq    SEQUENCE     ?   ALTER TABLE public."Card" ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."Card_id_seq"
    START WITH 1000000000000000
    INCREMENT BY 1
    MINVALUE 1000000000000000
    MAXVALUE 4499999999999999
    CACHE 1
);
            public          postgres    false    212            ?            1259    16525    Client    TABLE       CREATE TABLE public."Client" (
    id bigint NOT NULL,
    name character varying(64) NOT NULL,
    surname character varying(64) NOT NULL,
    "nameOfFather" character varying(64),
    "phoneNumber" character(12) NOT NULL,
    "dateOfBirth" date NOT NULL
);
    DROP TABLE public."Client";
       public         heap    postgres    false            ?            1259    16524    Client_id_seq    SEQUENCE     ?   ALTER TABLE public."Client" ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."Client_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    210            ?            1259    16555    Login    TABLE     ?   CREATE TABLE public."Login" (
    username character varying(64) NOT NULL,
    password character varying(64) NOT NULL,
    "resetQuestion" text NOT NULL,
    "resetAnswer" text NOT NULL,
    "idOfClient" bigint NOT NULL
);
    DROP TABLE public."Login";
       public         heap    postgres    false            ?            1259    16598    MultiCurrencyCard    TABLE     }  CREATE TABLE public."MultiCurrencyCard" (
    id bigint NOT NULL,
    "mainBalance" double precision NOT NULL,
    "mainCurrency" character(3) NOT NULL,
    activity boolean NOT NULL,
    cvc smallint NOT NULL,
    "paymentSystem" character varying(10) NOT NULL,
    "dateOfCreation" date NOT NULL,
    "dateOfEnd" date NOT NULL,
    "secondBalance" double precision NOT NULL,
    "secondCurrency" character(3) NOT NULL,
    "thirdBalance" double precision NOT NULL,
    "thirdCurrency" character(3) NOT NULL,
    "fourthBalance" double precision NOT NULL,
    "fourthCurrency" character(3) NOT NULL,
    "idOfClient" bigint NOT NULL
);
 '   DROP TABLE public."MultiCurrencyCard";
       public         heap    postgres    false            ?            1259    16597    MultiCurrencyCard_id_seq    SEQUENCE       ALTER TABLE public."MultiCurrencyCard" ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."MultiCurrencyCard_id_seq"
    START WITH 4500000000000000
    INCREMENT BY 1
    MINVALUE 4500000000000000
    MAXVALUE 9999999999999999
    CACHE 1
);
            public          postgres    false    215            ?            1259    16664    PriorityCard    TABLE     f   CREATE TABLE public."PriorityCard" (
    id bigint NOT NULL,
    card bigint,
    multicard bigint
);
 "   DROP TABLE public."PriorityCard";
       public         heap    postgres    false                      0    16531    Card 
   TABLE DATA           ?   COPY public."Card" (id, "mainBalance", "mainCurrency", activity, cvc, "paymentSystem", "dateOfCreation", "dateOfEnd", "idOfClient") FROM stdin;
    public          postgres    false    212   ?'                 0    16525    Client 
   TABLE DATA           c   COPY public."Client" (id, name, surname, "nameOfFather", "phoneNumber", "dateOfBirth") FROM stdin;
    public          postgres    false    210   N(                 0    16555    Login 
   TABLE DATA           c   COPY public."Login" (username, password, "resetQuestion", "resetAnswer", "idOfClient") FROM stdin;
    public          postgres    false    213   ?(                 0    16598    MultiCurrencyCard 
   TABLE DATA             COPY public."MultiCurrencyCard" (id, "mainBalance", "mainCurrency", activity, cvc, "paymentSystem", "dateOfCreation", "dateOfEnd", "secondBalance", "secondCurrency", "thirdBalance", "thirdCurrency", "fourthBalance", "fourthCurrency", "idOfClient") FROM stdin;
    public          postgres    false    215   Z)                 0    16664    PriorityCard 
   TABLE DATA           =   COPY public."PriorityCard" (id, card, multicard) FROM stdin;
    public          postgres    false    216   ?)                  0    0    Card_id_seq    SEQUENCE SET     J   SELECT pg_catalog.setval('public."Card_id_seq"', 1000000000000004, true);
          public          postgres    false    211                       0    0    Client_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public."Client_id_seq"', 5, true);
          public          postgres    false    209                       0    0    MultiCurrencyCard_id_seq    SEQUENCE SET     W   SELECT pg_catalog.setval('public."MultiCurrencyCard_id_seq"', 4500000000000017, true);
          public          postgres    false    214            s           2606    16596    Card Card_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public."Card"
    ADD CONSTRAINT "Card_pkey" PRIMARY KEY (id);
 <   ALTER TABLE ONLY public."Card" DROP CONSTRAINT "Card_pkey";
       public            postgres    false    212            o           2606    16529    Client Client_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public."Client"
    ADD CONSTRAINT "Client_pkey" PRIMARY KEY (id);
 @   ALTER TABLE ONLY public."Client" DROP CONSTRAINT "Client_pkey";
       public            postgres    false    210            q           2606    16611    Client Client_unique 
   CONSTRAINT     \   ALTER TABLE ONLY public."Client"
    ADD CONSTRAINT "Client_unique" UNIQUE ("phoneNumber");
 B   ALTER TABLE ONLY public."Client" DROP CONSTRAINT "Client_unique";
       public            postgres    false    210            u           2606    16561    Login Login_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public."Login"
    ADD CONSTRAINT "Login_pkey" PRIMARY KEY (username);
 >   ALTER TABLE ONLY public."Login" DROP CONSTRAINT "Login_pkey";
       public            postgres    false    213            w           2606    16609 (   MultiCurrencyCard MultiCurrencyCard_pkey 
   CONSTRAINT     j   ALTER TABLE ONLY public."MultiCurrencyCard"
    ADD CONSTRAINT "MultiCurrencyCard_pkey" PRIMARY KEY (id);
 V   ALTER TABLE ONLY public."MultiCurrencyCard" DROP CONSTRAINT "MultiCurrencyCard_pkey";
       public            postgres    false    215            y           2606    16668    PriorityCard PriorityCard_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public."PriorityCard"
    ADD CONSTRAINT "PriorityCard_pkey" PRIMARY KEY (id);
 L   ALTER TABLE ONLY public."PriorityCard" DROP CONSTRAINT "PriorityCard_pkey";
       public            postgres    false    216            z           2606    16536    Card Card_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public."Card"
    ADD CONSTRAINT "Card_fkey" FOREIGN KEY ("idOfClient") REFERENCES public."Client"(id) NOT VALID;
 <   ALTER TABLE ONLY public."Card" DROP CONSTRAINT "Card_fkey";
       public          postgres    false    210    212    3183            }           2606    16669    PriorityCard Card_fkey    FK CONSTRAINT     w   ALTER TABLE ONLY public."PriorityCard"
    ADD CONSTRAINT "Card_fkey" FOREIGN KEY (card) REFERENCES public."Card"(id);
 D   ALTER TABLE ONLY public."PriorityCard" DROP CONSTRAINT "Card_fkey";
       public          postgres    false    216    3187    212            {           2606    16562    Login Login_fkey    FK CONSTRAINT     {   ALTER TABLE ONLY public."Login"
    ADD CONSTRAINT "Login_fkey" FOREIGN KEY ("idOfClient") REFERENCES public."Client"(id);
 >   ALTER TABLE ONLY public."Login" DROP CONSTRAINT "Login_fkey";
       public          postgres    false    3183    213    210            ~           2606    16674    PriorityCard MCard_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public."PriorityCard"
    ADD CONSTRAINT "MCard_fkey" FOREIGN KEY (multicard) REFERENCES public."MultiCurrencyCard"(id);
 E   ALTER TABLE ONLY public."PriorityCard" DROP CONSTRAINT "MCard_fkey";
       public          postgres    false    216    215    3191            |           2606    16603 (   MultiCurrencyCard MultiCurrencyCard_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public."MultiCurrencyCard"
    ADD CONSTRAINT "MultiCurrencyCard_fkey" FOREIGN KEY ("idOfClient") REFERENCES public."Client"(id);
 V   ALTER TABLE ONLY public."MultiCurrencyCard" DROP CONSTRAINT "MultiCurrencyCard_fkey";
       public          postgres    false    210    215    3183               r   x?]?1?0????.?????#R??8?mRZ/?%??i?A??u????xޖ+???B??-)<b?N?^?M4Y3?2??X?M?)?r??V?/ϒcj??TK??5??????,?         ?   x?=ͻ!??zx?????+-m0?%?B??d}z?F??8_??}??&}MOO綴e??1F3*b& ?P??Ă`ײ?0???_??2???F&V?;??D%???????t?uc????$	%9q?
!??D*q         f   x?+N-???4426153??44???TH?OW?K?M??t?.?/?4??--J,?ί?HL??AW??XU??XT2??$????3?U(,???y?`.?W? ??%G         E   x?315@?????Q!?%?&??a????FFF????F ?)?i??$]C??dP??W? }a            x?3?44@&?1~\1z\\\ C[?     