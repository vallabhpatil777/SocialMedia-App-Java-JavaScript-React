import HomeIcon from "@mui/icons-material/Home";
import ExploreIcon from "@mui/icons-material/Explore";
import ControlPointIcon from "@mui/icons-material/ControlPoint";
import NotificationsIcon from "@mui/icons-material/Notifications";
import MessageIcon from "@mui/icons-material/Message";
import ListIcon from "@mui/icons-material/List";
import AccountCircleIcon from "@mui/icons-material/AccountCircle";
import GroupIcon from "@mui/icons-material/Group";
export const navigationMenu = [
  {
    title: "Home",
    icon: <HomeIcon />,
    path: "/",
  },
  {
    title: "Reels",
    icon: <ExploreIcon />,
    path: "/reels",
  },
  {
    title: "Create Reels",
    icon: <ControlPointIcon />,
    path: "/create-reels",
  },
  {
    title: "Notifications",
    icon: <NotificationsIcon />,
    path: "/notifications",
  },
  {
    title: "Message",
    icon: <MessageIcon />,
    path: "/message",
  },
  {
    title: "Lists",
    icon: <ListIcon />,
    path: "/lists",
  },
  {
    title: "Communities",
    icon: <GroupIcon />,
    path: "/communities",
  },
  {
    title: "Profile",
    icon: <AccountCircleIcon />,
    path: "/profile",
  },
];
