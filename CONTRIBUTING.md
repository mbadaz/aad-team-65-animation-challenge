# How to Contribute


- Fork this repository - [How to fork a repository](https://services.github.com/on-demand/intro-to-github/create-pull-request)
- Clone the forked repository into local space
- Open an issue to indicate the task you want to work on e.g Adding SharedElementTransitions scenario

- Optional - You can add comments at the start of the file, if you want to share something, like any complex logic you might have added.
- Add and commit the changes. (Please do not make changes in any other file, but if you want to work on bug/improvement then also indicate the issue first)
- Generate a Pull Request (Optional: add problem name in the title and what you worked on in the description)
- That's it!

# How to Sync Forked Repo from Upstream Repo
1. Add the original repository as an upstream repository
```javascript
$ git remote add upstream https://github.com/[Original Owner Username]/[Original Repository].git
```
Hence, in this repository it would be
```javascript
$ git remote add upstream https://github.com/mbadaz/aad-team-65-animation-challenge.git 
```

2. Fetch all the changes from the repository. Note that commits to the original repository will be stored in a local branch called, upstream/master
```javascript
$ git fetch upstream
```

3. Make sure that you are on your fork's master or working branch
```javascript
$ git checkout [working branch]
```
For example,
```javascript
$ git checkout master
```

4. Merge the changes from the upstream/master into  your local master or working branch. This will sync the fork's master branch with the upstream repository without losing your local changes. If you have made any changes that create conflict, you will have to resolve the conflict before you can complete the merge
```javascript
$ git merge upstream/master
```

5. At this point, your local branch is synced with the upstream/master branch. In order to update the remote branch in Github, you need to push your changes
```javascript
$ git push origin master
```
