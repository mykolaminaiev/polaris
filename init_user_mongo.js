db = db.getSiblingDB('polaris');
var cloudTrailId = new ObjectId();
var awsAccountId = new ObjectId();
db.awsCloudTrailConfiguration.insert({
		_id:cloudTrailId,
        trail:"trail",
        bucket:"bucket",
        log_prefix:"prefix"
});
db.awsAccount.insert({
		_id:awsAccountId,
        name:"name",
        access_key:"access_key",
        secret_key:"secret_key",
		cloudTrailConfiguration: new DBRef("awsCloudTrailConfiguration", cloudTrailId)
});
db.user.insert({
        name:"name",
        password:"password",
        email:"email",
        awsAccount:new DBRef("awsAccount", awsAccountId)
});

