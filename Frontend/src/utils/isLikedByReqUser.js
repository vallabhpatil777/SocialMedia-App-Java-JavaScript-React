export const isLikedByReqUser = (reqUserId,post)=>{

    for(let user of post.liked){
        if(user.id ===reqUserId){
            console.log("In islikedbyreq:", user.id)
            return true
        }
    }
    return false
}