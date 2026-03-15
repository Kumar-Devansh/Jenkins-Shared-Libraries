def call(string url, string branch){
  echo "Cloning The Code"
  git url: "${url}", branch: "${branch}"
}
