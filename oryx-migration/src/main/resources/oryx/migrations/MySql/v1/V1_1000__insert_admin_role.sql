--User Admin
INSERT INTO T_USER (ID,VERSION,DOMAIN_CODE,CREATED_BY,CREATE_DATE,UPDATE_DATE,UPDATED_BY,CANCEL_DATE,CANCELED_BY,CHECK_CANCEL,EMAIL,LAST_CONNECTION,LOGIN,PASSWORD,USER_ROLE,STATUS,PERSON_ID)
VALUES (unhex(replace(uuid(),'-','')),1,null,null,SYSDATE(),SYSDATE(),null,null,null,false,'root.admin@oryx.com',SYSDATE(),'root','OryxRoot','ROLE_ADMIN','ACTIVE',null);

--Role Admin
INSERT INTO T_ROLE_INFO (ID,VERSION,DOMAIN_CODE,CREATED_BY,CREATE_DATE,UPDATE_DATE,UPDATED_BY,CANCEL_DATE,CANCELED_BY,CHECK_CANCEL,DESCRIPTION,ROLE_NAME,STATUS)
VALUES (unhex(replace(uuid(),'-','')),1,null,null,SYSDATE(),SYSDATE(),null,null,null,false,'Administrateur','ADMIN_ROLE','ACTIVE');

--Menu Admin
INSERT INTO T_MENU (ID,VERSION,DOMAIN_CODE,CREATED_BY,CREATE_DATE,UPDATE_DATE,UPDATED_BY,CANCEL_DATE,CANCELED_BY,CHECK_CANCEL,DESCRIPTION,NAME,STATUS)
VALUES (unhex(replace(uuid(),'-','')),1,null,null,SYSDATE(),SYSDATE(),null,null,null,false,'Administrateur','ADMIN_MENU','ACTIVE');

--All tasks
INSERT INTO T_TASK (ID,VERSION,DOMAIN_CODE,CREATED_BY,CREATE_DATE,UPDATE_DATE,UPDATED_BY,CANCEL_DATE,CANCELED_BY,CHECK_CANCEL,DESCRIPTION,NAME,PERMISSION,STATUS)
VALUES (unhex(replace(uuid(),'-','')),1,null,null,SYSDATE(),SYSDATE(),null,null,null,false,'Gestion des messages d erreurs','XmlErrorMessage','UPDATE','ACTIVE');
INSERT INTO T_TASK (ID,VERSION,DOMAIN_CODE,CREATED_BY,CREATE_DATE,UPDATE_DATE,UPDATED_BY,CANCEL_DATE,CANCELED_BY,CHECK_CANCEL,DESCRIPTION,NAME,PERMISSION,STATUS)
VALUES (unhex(replace(uuid(),'-','')),1,null,null,SYSDATE(),SYSDATE(),null,null,null,false,'Gestion des traductions','XmlTranslation','UPDATE','ACTIVE');
INSERT INTO T_TASK (ID,VERSION,DOMAIN_CODE,CREATED_BY,CREATE_DATE,UPDATE_DATE,UPDATED_BY,CANCEL_DATE,CANCELED_BY,CHECK_CANCEL,DESCRIPTION,NAME,PERMISSION,STATUS)
VALUES (unhex(replace(uuid(),'-','')),1,null,null,SYSDATE(),SYSDATE(),null,null,null,false,'Gestion des annexes','XmAnnex','UPDATE','ACTIVE');
INSERT INTO T_TASK (ID,VERSION,DOMAIN_CODE,CREATED_BY,CREATE_DATE,UPDATE_DATE,UPDATED_BY,CANCEL_DATE,CANCELED_BY,CHECK_CANCEL,DESCRIPTION,NAME,PERMISSION,STATUS)
VALUES (unhex(replace(uuid(),'-','')),1,null,null,SYSDATE(),SYSDATE(),null,null,null,false,'Gestion des codifications','XmlCodification','UPDATE','ACTIVE');
INSERT INTO T_TASK (ID,VERSION,DOMAIN_CODE,CREATED_BY,CREATE_DATE,UPDATE_DATE,UPDATED_BY,CANCEL_DATE,CANCELED_BY,CHECK_CANCEL,DESCRIPTION,NAME,PERMISSION,STATUS)
VALUES (unhex(replace(uuid(),'-','')),1,null,null,SYSDATE(),SYSDATE(),null,null,null,false,'Gestion des domaines','XmlDomain','UPDATE','ACTIVE');
INSERT INTO T_TASK (ID,VERSION,DOMAIN_CODE,CREATED_BY,CREATE_DATE,UPDATE_DATE,UPDATED_BY,CANCEL_DATE,CANCELED_BY,CHECK_CANCEL,DESCRIPTION,NAME,PERMISSION,STATUS)
VALUES (unhex(replace(uuid(),'-','')),1,null,null,SYSDATE(),SYSDATE(),null,null,null,false,'Gestion des parametrages','XmlFieldProcessParam','UPDATE','ACTIVE');
INSERT INTO T_TASK (ID,VERSION,DOMAIN_CODE,CREATED_BY,CREATE_DATE,UPDATE_DATE,UPDATED_BY,CANCEL_DATE,CANCELED_BY,CHECK_CANCEL,DESCRIPTION,NAME,PERMISSION,STATUS)
VALUES (unhex(replace(uuid(),'-','')),1,null,null,SYSDATE(),SYSDATE(),null,null,null,false,'Gestion des menus','XmlMenu','UPDATE','ACTIVE');
INSERT INTO T_TASK (ID,VERSION,DOMAIN_CODE,CREATED_BY,CREATE_DATE,UPDATE_DATE,UPDATED_BY,CANCEL_DATE,CANCELED_BY,CHECK_CANCEL,DESCRIPTION,NAME,PERMISSION,STATUS)
VALUES (unhex(replace(uuid(),'-','')),1,null,null,SYSDATE(),SYSDATE(),null,null,null,false,'Gestion des roles','XmlRoleInfo','UPDATE','ACTIVE');
INSERT INTO T_TASK (ID,VERSION,DOMAIN_CODE,CREATED_BY,CREATE_DATE,UPDATE_DATE,UPDATED_BY,CANCEL_DATE,CANCELED_BY,CHECK_CANCEL,DESCRIPTION,NAME,PERMISSION,STATUS)
VALUES (unhex(replace(uuid(),'-','')),1,null,null,SYSDATE(),SYSDATE(),null,null,null,false,'Gestion des tâches','XmlTask','UPDATE','ACTIVE');
INSERT INTO T_TASK (ID,VERSION,DOMAIN_CODE,CREATED_BY,CREATE_DATE,UPDATE_DATE,UPDATED_BY,CANCEL_DATE,CANCELED_BY,CHECK_CANCEL,DESCRIPTION,NAME,PERMISSION,STATUS)
VALUES (unhex(replace(uuid(),'-','')),1,null,null,SYSDATE(),SYSDATE(),null,null,null,false,'Gestion des mise à jours','XmlUpgrades','UPDATE','ACTIVE');
INSERT INTO T_TASK (ID,VERSION,DOMAIN_CODE,CREATED_BY,CREATE_DATE,UPDATE_DATE,UPDATED_BY,CANCEL_DATE,CANCELED_BY,CHECK_CANCEL,DESCRIPTION,NAME,PERMISSION,STATUS)
VALUES (unhex(replace(uuid(),'-','')),1,null,null,SYSDATE(),SYSDATE(),null,null,null,false,'Gestion des utilisateurs','XmlUser','UPDATE','ACTIVE');
INSERT INTO T_TASK (ID,VERSION,DOMAIN_CODE,CREATED_BY,CREATE_DATE,UPDATE_DATE,UPDATED_BY,CANCEL_DATE,CANCELED_BY,CHECK_CANCEL,DESCRIPTION,NAME,PERMISSION,STATUS)
VALUES (unhex(replace(uuid(),'-','')),1,null,null,SYSDATE(),SYSDATE(),null,null,null,false,'Gestion des adresse','XmlAdress','UPDATE','ACTIVE');
INSERT INTO T_TASK (ID,VERSION,DOMAIN_CODE,CREATED_BY,CREATE_DATE,UPDATE_DATE,UPDATED_BY,CANCEL_DATE,CANCELED_BY,CHECK_CANCEL,DESCRIPTION,NAME,PERMISSION,STATUS)
VALUES (unhex(replace(uuid(),'-','')),1,null,null,SYSDATE(),SYSDATE(),null,null,null,false,'Gestion des contacts','XmlContact','UPDATE','ACTIVE');
INSERT INTO T_TASK (ID,VERSION,DOMAIN_CODE,CREATED_BY,CREATE_DATE,UPDATE_DATE,UPDATED_BY,CANCEL_DATE,CANCELED_BY,CHECK_CANCEL,DESCRIPTION,NAME,PERMISSION,STATUS)
VALUES (unhex(replace(uuid(),'-','')),1,null,null,SYSDATE(),SYSDATE(),null,null,null,false,'Gestion des pays','XmlCountry','UPDATE','ACTIVE');
INSERT INTO T_TASK (ID,VERSION,DOMAIN_CODE,CREATED_BY,CREATE_DATE,UPDATE_DATE,UPDATED_BY,CANCEL_DATE,CANCELED_BY,CHECK_CANCEL,DESCRIPTION,NAME,PERMISSION,STATUS)
VALUES (unhex(replace(uuid(),'-','')),1,null,null,SYSDATE(),SYSDATE(),null,null,null,false,'Gestion des personnes','XmlPerson','UPDATE','ACTIVE');
INSERT INTO T_TASK (ID,VERSION,DOMAIN_CODE,CREATED_BY,CREATE_DATE,UPDATE_DATE,UPDATED_BY,CANCEL_DATE,CANCELED_BY,CHECK_CANCEL,DESCRIPTION,NAME,PERMISSION,STATUS)
VALUES (unhex(replace(uuid(),'-','')),1,null,null,SYSDATE(),SYSDATE(),null,null,null,false,'Gestion des villes','XmlState','UPDATE','ACTIVE');
INSERT INTO T_TASK (ID,VERSION,DOMAIN_CODE,CREATED_BY,CREATE_DATE,UPDATE_DATE,UPDATED_BY,CANCEL_DATE,CANCELED_BY,CHECK_CANCEL,DESCRIPTION,NAME,PERMISSION,STATUS)
VALUES (unhex(replace(uuid(),'-','')),1,null,null,SYSDATE(),SYSDATE(),null,null,null,false,'Gestion des identificateurs','XmlUid','UPDATE','ACTIVE');