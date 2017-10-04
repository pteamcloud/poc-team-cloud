
insert into ptcusername(ptcuser_name) values ('kisvish');

insert into contribution (contributor_idPTCUserName, contribution_amount, contribution_created, contribution_updated) values ('1', 35, NOW(), NOW())

insert into ptcusername_contribution (ptcusername_idPTCUserName,contribution_idContribution) values (1, 1)


