def call(String url, String branch){
  echo "Cloning The Code"
  git url: "${url}", branch: "${branch}"
}
