import {
  Avatar,
  Card,
  CardActions,
  CardContent,
  CardHeader,
  CardMedia,
  Divider,
  IconButton,
  Typography,
} from "@mui/material";
import FavoriteIcon from "@mui/icons-material/Favorite";

import React, { useState } from "react";
import MoreVertIcon from "@mui/icons-material/MoreVert";
import { red } from "@mui/material/colors";

import ShareIcon from "@mui/icons-material/Share";
import FavoriteBorderIcon from "@mui/icons-material/FavoriteBorder";
import ChatBubbleIcon from "@mui/icons-material/ChatBubble";
import BookmarkIcon from "@mui/icons-material/Bookmark";
import BookmarkBorderIcon from "@mui/icons-material/BookmarkBorder";
import { useDispatch, useSelector } from "react-redux";
import { createCommentAction, likePostAction } from "../Redux/Post/post.action";
import { isLikedByReqUser } from "../utils/isLikedByReqUser";
const PostCard = ({ item }) => {
  //console.log("item", item);
  const [showComments, setShowComments] = useState(false);
  const { post, auth } = useSelector((store) => store);
  const handleShowComment = () => setShowComments(!showComments);
  const dispatch = useDispatch();

  const handleLikePost = () => {
    dispatch(likePostAction(item.id));
  };
  const handleCreateComment = (content) => {
    const reqData = {
      postId: item.id,
      data: {
        content,
      },
    };
    dispatch(createCommentAction(reqData));
  };
  console.log("is liked : ", isLikedByReqUser(auth.user.id, item));
  //console.log("img : ", item.image);
  return (
    <Card className="">
      <CardHeader
        avatar={
          <Avatar sx={{ bgcolor: red[500] }} aria-label="cat">
            {item.user?.firstName[0]}
          </Avatar>
        }
        action={
          <IconButton aria-label="settings">
            <MoreVertIcon />
          </IconButton>
        }
        title={item.user.firstName + " " + item.user.lastName}
        subheader={
          "@" +
          item.user?.firstName.toLowerCase() +
          "_" +
          item.user?.lastName.toLowerCase()
        }
      />
      {/*<CardMedia component="img" height="194" image={item.image} alt="Cat" />*/}
      <img
        className="w-full max-h-[40rem] object-cover object-top "
        src={item.image}
        alt=""
      />
      <CardContent>
        <Typography variant="body2" sx={{ color: "text.secondary" }}>
          {item.caption}
        </Typography>
      </CardContent>

      <CardActions className="flex justify-between" disableSpacing>
        <div>
          <IconButton onClick={handleLikePost} aria-label="add to favorites">
            {isLikedByReqUser(auth.user.id, item) ? (
              <FavoriteIcon />
            ) : (
              <FavoriteBorderIcon />
            )}
          </IconButton>

          <IconButton aria-label="share">
            <ShareIcon />
          </IconButton>
          <IconButton onClick={handleShowComment} aria-label="chat">
            <ChatBubbleIcon />
          </IconButton>
        </div>
        <div>
          <IconButton aria-label="add to favorites">
            {true ? <BookmarkIcon /> : <BookmarkBorderIcon />}
          </IconButton>
        </div>
      </CardActions>

      {showComments && (
        <section>
          <div className="flex items-center space-x-5 mx-3 my-5">
            <Avatar sx={{}} />
            <input
              onKeyPress={(e) => {
                if (e.key == "Enter") {
                  handleCreateComment(e.target.value);
                  console.log("e for comment", e.target.value);
                }
              }}
              className="w-full outline-none bg-transparent border border-[#3b4050] rounded-full px-5 py-2"
              type="text"
              placeholder="write your comment..."
            />
          </div>

          <Divider />
          <div className="mx-3 space-y-2 my-5 text-xs">
            {item.comments.map((comment) => (
              <div className="flex items-center space-x-5">
                <Avatar
                  sx={{ height: "2rem", width: "2rem", fontSize: ".8rem" }}
                >
                  {comment.user?.firstName[0]}
                </Avatar>
                <p>{comment.content}</p>
              </div>
            ))}
          </div>
        </section>
      )}
    </Card>
  );
};

export default PostCard;
